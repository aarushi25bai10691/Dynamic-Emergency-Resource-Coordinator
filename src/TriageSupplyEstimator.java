import java.util.Scanner;

public class TriageSupplyEstimator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== EMERGENCY MEDICAL TRIAGE ESTIMATOR ===");

        System.out.print("Enter count of Critical Patients (Red Tag): ");
        int critical = scanner.nextInt();

        System.out.print("Enter count of Serious Patients (Yellow Tag): ");
        int serious = scanner.nextInt();

        System.out.print("Enter count of Minor Patients (Green Tag): ");
        int minor = scanner.nextInt();

        int totalPatients = critical + serious + minor;

        // Supply formulas based on field triage standards
        int ivFluidsNeeded = (critical * 3) + (serious * 1);
        int bandageKitsNeeded = (critical * 5) + (serious * 3) + (minor * 1);
        int bloodBagsNeeded = (critical * 2);

        System.out.println("\n---------------- REQUIRED AID ESTIMATE ----------------");
        System.out.println("Total Casualties Processed : " + totalPatients);
        System.out.println("IV Fluid Bags Required     : " + ivFluidsNeeded + " units");
        System.out.println("Bandage/Dressing Kits      : " + bandageKitsNeeded + " packs");
        System.out.println("Blood Bags (Universal O-)  : " + bloodBagsNeeded + " units");
        System.out.println("------------------------------------------------------");

        scanner.close();
    }
}
