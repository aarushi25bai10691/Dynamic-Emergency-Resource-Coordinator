import java.util.Scanner;

public class SosPriorityAssessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CRISISRELIEF: SOS PRIORITY ASSESSOR ===");

        System.out.print("Enter Relief Category (e.g., Medical, Water, Shelter): ");
        String category = scanner.nextLine();

        System.out.print("Enter Target Location / Zone: ");
        String location = scanner.nextLine();

        System.out.print("Enter Urgency Level (1 - 10): ");
        int urgency = scanner.nextInt();

        System.out.print("Enter Disaster Severity Index (1 - 10): ");
        int severity = scanner.nextInt();

        System.out.print("Enter Elapsed Waiting Time (in minutes): ");
        long waitTime = scanner.nextLong();

        // Priority Score Formula: (Urgency * 0.5) + (WaitTime / 60 * 0.3) + (Severity * 0.2)
        double priorityScore = (urgency * 0.5) + ((waitTime / 60.0) * 0.3) + (severity * 0.2);

        System.out.println("\n---------------- EVALUATION RESULT ----------------");
        System.out.println("Location       : " + location);
        System.out.println("Item Category  : " + category);
        System.out.printf("Priority Score : %.2f%n", priorityScore);

        if (priorityScore >= 6.0) {
            System.out.println("Dispatch Status: [CRITICAL] Immediate dispatch required!");
        } else if (priorityScore >= 3.5) {
            System.out.println("Dispatch Status: [HIGH] Schedule in next dispatch batch.");
        } else {
            System.out.println("Dispatch Status: [STANDARD] Queue for regular allocation.");
        }

        scanner.close();
    }
}
