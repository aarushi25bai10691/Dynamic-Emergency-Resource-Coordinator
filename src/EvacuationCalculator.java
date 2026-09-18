import java.util.Scanner;

public class EvacuationCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== EVACUATION FLEET & FUEL CALCULATOR ===");

        System.out.print("Enter total number of refugees to evacuate: ");
        int people = scanner.nextInt();

        System.out.print("Enter vehicle capacity (people per bus/truck): ");
        int capacity = scanner.nextInt();

        System.out.print("Enter distance to safety hub (in km): ");
        double distance = scanner.nextDouble();

        System.out.print("Enter vehicle fuel efficiency (km per liter): ");
        double kmPerLiter = scanner.nextDouble();

        // Calculate total trips (round up)
        int requiredTrips = (int) Math.ceil((double) people / capacity);
        double totalDistance = requiredTrips * 2 * distance; // Round trips
        double totalFuel = totalDistance / kmPerLiter;

        System.out.println("\n---------------- LOGISTICS SUMMARY ----------------");
        System.out.println("Required One-Way Vehicle Trips : " + requiredTrips);
        System.out.printf("Total Fleet Distance (Roundtrip): %.1f km%n", totalDistance);
        System.out.printf("Total Fuel Consumption Required : %.2f Liters%n", totalFuel);
        System.out.println("---------------------------------------------------");

        scanner.close();
    }
}
