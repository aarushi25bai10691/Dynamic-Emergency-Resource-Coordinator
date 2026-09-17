import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    // Data Model for Emergency SOS Requests
    static class SosRequest {
        String requestId;
        String location;
        String category;
        int urgency;       // Scale 1-10
        int severity;      // Scale 1-10
        long waitTimeMinutes;
        double priorityScore;
        String status;     // "OPEN" or "DISPATCHED"

        public SosRequest(String requestId, String location, String category, int urgency, int severity, long waitTimeMinutes) {
            this.requestId = requestId;
            this.location = location;
            this.category = category;
            this.urgency = urgency;
            this.severity = severity;
            this.waitTimeMinutes = waitTimeMinutes;
            this.status = "OPEN";
            this.priorityScore = calculatePriorityScore();
        }

        // Weighted Formula: (Urgency * 0.5) + (WaitTime / 60 * 0.3) + (Severity * 0.2)
        public double calculatePriorityScore() {
            return (urgency * 0.5) + ((waitTimeMinutes / 60.0) * 0.3) + (severity * 0.2);
        }
    }

    // Business Logic Engine for Inventory and Priority Dispatching
    static class ReliefService {
        private Map<String, Integer> inventory = new HashMap<>();
        private List<SosRequest> requestList = new ArrayList<>();

        public void addInventory(String category, int quantity) {
            inventory.put(category, inventory.getOrDefault(category, 0) + quantity);
        }

        public void addRequest(SosRequest request) {
            requestList.add(request);
        }

        public void displayInitialState() {
            System.out.println("==================================================");
            System.out.println("     CRISISRELIEF: INITIAL SYSTEM DASHBOARD      ");
            System.out.println("==================================================");

            System.out.println("\n--- Current Warehouse Inventory ---");
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.printf("Item: %-15s | Units Available: %d%n", entry.getKey(), entry.getValue());
            }

            System.out.println("\n--- Logged Pending SOS Requests ---");
            for (SosRequest req : requestList) {
                System.out.printf("[%s] Location: %-10s | Category: %-12s | Urgency: %d | Severity: %d | Wait: %d mins | Score: %.2f | Status: %s%n",
                        req.requestId, req.location, req.category, req.urgency, req.severity, req.waitTimeMinutes, req.priorityScore, req.status);
            }
        }

        public void processDispatchQueue() {
            System.out.println("\n==================================================");
            System.out.println("       RUNNING AUTOMATED DISPATCH ENGINE...       ");
            System.out.println("==================================================");

            // Sort requests by priority score in descending order
            Collections.sort(requestList, new Comparator<SosRequest>() {
                @Override
                public int compare(SosRequest r1, SosRequest r2) {
                    return Double.compare(r2.priorityScore, r1.priorityScore);
                }
            });

            for (SosRequest req : requestList) {
                int availableQty = inventory.getOrDefault(req.category, 0);

                if (availableQty > 0) {
                    // Match request and auto-deduct stock
                    inventory.put(req.category, availableQty - 1);
                    req.status = "DISPATCHED";
                    System.out.printf("[SUCCESS] Dispatched %s to %s (Score: %.2f). Remaining stock of %s: %d%n",
                            req.category, req.location, req.priorityScore, req.category, inventory.get(req.category));
                } else {
                    // Insufficient stock handling
                    System.out.printf("[OUT OF STOCK] Cannot fulfill request for %s at %s (Score: %.2f). Status remains OPEN.%n",
                            req.category, req.location, req.priorityScore);
                }
            }
        }

        public void displayFinalState() {
            System.out.println("\n==================================================");
            System.out.println("      POST-DISPATCH SUMMARY & DASHBOARD REPORT    ");
            System.out.println("==================================================");

            System.out.println("\n--- Updated Request Status Queue (Sorted by Priority) ---");
            for (SosRequest req : requestList) {
                System.out.printf("[%s] Location: %-10s | Category: %-12s | Score: %.2f | Status: [%s]%n",
                        req.requestId, req.location, req.category, req.priorityScore, req.status);
            }

            System.out.println("\n--- Remaining Warehouse Inventory ---");
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.printf("Item: %-15s | Units Remaining: %d%n", entry.getKey(), entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        ReliefService service = new ReliefService();

        // 1. Seed Warehouse Stock
        service.addInventory("Medical Kit", 2);
        service.addInventory("Water Crate", 5);
        service.addInventory("Shelter Kit", 0); // Tested out-of-stock scenario

        // 2. Seed Pending Emergency Requests
        service.addRequest(new SosRequest("REQ-101", "Zone Alpha", "Medical Kit", 9, 8, 120));  // High Priority
        service.addRequest(new SosRequest("REQ-102", "Zone Beta",  "Water Crate", 5, 4, 30));   // Low Priority
        service.addRequest(new SosRequest("REQ-103", "Zone Gamma", "Shelter Kit", 10, 9, 180)); // Critical, but Out-of-Stock
        service.addRequest(new SosRequest("REQ-104", "Zone Delta", "Medical Kit", 8, 7, 45));   // High Priority, competes for limited stock
        service.addRequest(new SosRequest("REQ-105", "Zone Epsilon","Medical Kit", 3, 2, 15));   // Low Priority, stock runs out

        // 3. Run System Pipeline
        service.displayInitialState();
        service.processDispatchQueue();
        service.displayFinalState();
    }
}
