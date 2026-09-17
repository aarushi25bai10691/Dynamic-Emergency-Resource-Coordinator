import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> inventory = new HashMap<>();

        // Default initial stock
        inventory.put("Medical Kit", 10);
        inventory.put("Water Crate", 25);
        inventory.put("Shelter Kit", 5);

        while (true) {
            System.out.println("\n=== CRISISRELIEF: INVENTORY MANAGER ===");
            System.out.println("1. View Current Stock");
            System.out.println("2. Add Stock");
            System.out.println("3. Deduct Stock (Dispatch)");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println("\n--- CURRENT WAREHOUSE STOCK ---");
                for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                    System.out.printf("Item: %-15s | Available Units: %d%n", entry.getKey(), entry.getValue());
                }
            } else if (choice == 2) {
                System.out.print("Enter Item Name: ");
                String item = scanner.nextLine();
                System.out.print("Enter Quantity to Add: ");
                int qty = scanner.nextInt();

                inventory.put(item, inventory.getOrDefault(item, 0) + qty);
                System.out.println("[SUCCESS] Added " + qty + " units to " + item);
            } else if (choice == 3) {
                System.out.print("Enter Item Name to Deduct: ");
                String item = scanner.nextLine();

                if (!inventory.containsKey(item)) {
                    System.out.println("[ERROR] Item not found in warehouse!");
                } else {
                    System.out.print("Enter Quantity to Deduct: ");
                    int qty = scanner.nextInt();
                    int currentStock = inventory.get(item);

                    if (qty > currentStock) {
                        System.out.println("[DENIED] Insufficient stock! Available: " + currentStock);
                    } else {
                        inventory.put(item, currentStock - qty);
                        System.out.println("[SUCCESS] Deducted " + qty + " units. Remaining: " + (currentStock - qty));
                    }
                }
            } else if (choice == 4) {
                System.out.println("Exiting Inventory Manager. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
        scanner.close();
    }
}
