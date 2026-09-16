package com.crisisrelief;

public class Main {
    public static void main(String[] args) {
        CrisisReliefService service = new CrisisReliefService();

        System.out.println("CRISISRELIEF: DISASTER EMERGENCY RESOURCE COORDINATOR");

        // Load initial warehouse stock
        service.addInventory(new ReliefInventory("Medical Kit", 2, "Central Hub"));
        service.addInventory(new ReliefInventory("Water", 2, "North Depot"));
        service.addInventory(new ReliefInventory("Shelter Kit", 0, "East Hub"));

        // SCENARIO 1: High Urgency (9) vs Low Urgency (3)
        service.addSosRequest(new SosRequest("Medical Kit", "Zone A", 9, 8, 10)); 
        service.addSosRequest(new SosRequest("Water", "Zone B", 3, 2, 5));        

        // SCENARIO 2: Waiting Time Escalation (Lower urgency 5 waiting 300 mins vs newer moderate request)
        service.addSosRequest(new SosRequest("Medical Kit", "Zone C", 5, 5, 300)); 

        // SCENARIO 3: Regional Severity Tie-Breaker (Same Urgency 7 & Wait Time 20 mins)
        service.addSosRequest(new SosRequest("Water", "Zone D", 7, 9, 20)); // Higher Severity (9)
        service.addSosRequest(new SosRequest("Water", "Zone E", 7, 3, 20)); // Lower Severity (3)

        // SCENARIO 4: Out-Of-Stock Handling ("Shelter Kit")
        service.addSosRequest(new SosRequest("Shelter Kit", "Zone F", 10, 10, 60)); 

        // Display dashboard before dispatch
        service.printDashboard();

        // SCENARIO 5: Dispatch Execution & Atomic Stock Integrity
        service.processDispatch();

        // Display dashboard after dispatch
        service.printDashboard();
    }
}
