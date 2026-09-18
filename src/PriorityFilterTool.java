import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Alert {
    String location;
    double score;

    public Alert(String location, double score) {
        this.location = location;
        this.score = score;
    }
}

public class PriorityFilterTool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Alert> alertQueue = new ArrayList<>();

        System.out.println("=== EMERGENCY ALERT QUEUE FILTER ===");
        System.out.print("How many incoming SOS alerts would you like to enter? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= count; i++) {
            System.out.println("\n--- Alert #" + i + " ---");
            System.out.print("Enter Location Name: ");
            String loc = scanner.nextLine();

            System.out.print("Enter Calculated Priority Score (1.0 - 10.0): ");
            double score = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            alertQueue.add(new Alert(loc, score));
        }

        System.out.print("\nEnter Minimum Priority Threshold to Filter (e.g., 5.0): ");
        double threshold = scanner.nextDouble();

        System.out.println("\n=== HIGH-PRIORITY ALERTS (Score >= " + threshold + ") ===");
        boolean found = false;
        for (Alert a : alertQueue) {
            if (a.score >= threshold) {
                System.out.printf("Location: %-15s | Priority Score: %.2f [DISPATCH READY]%n", a.location, a.score);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No requests met or exceeded the threshold score of " + threshold);
        }

        scanner.close();
    }
}
