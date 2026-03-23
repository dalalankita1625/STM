import java.util.Scanner;

/**
 * Main.java
 * Entry point for the Student Task Manager.
 * Handles all user interaction through a simple console menu.
 *
 * How to run:
 *   javac Task.java TaskManager.java Main.java
 *   java Main
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);
    static TaskManager manager = new TaskManager();

    public static void main(String[] args) {
        printBanner();

        boolean running = true;

        while (running) {
            printMenu();
            int choice = getIntInput("  Enter your choice: ");

            switch (choice) {
                case 1 -> addTask();
                case 2 -> markTaskDone();
                case 3 -> deleteTask();
                case 4 -> manager.viewAllTasks();
                case 5 -> manager.viewPendingTasks();
                case 6 -> manager.showSummary();
                case 7 -> {
                    System.out.println("\n  👋  Good luck with your studies! See you soon.\n");
                    running = false;
                }
                default -> System.out.println("  ⚠  Invalid option. Please enter a number from 1 to 7.");
            }

            if (running) {
                System.out.println();
                pause();
            }
        }

        scanner.close();
    }

    // ── Feature Handlers ────────────────────────────────────────────────────

    static void addTask() {
        System.out.print("\n  Enter task name: ");
        String name = scanner.nextLine().trim();
        manager.addTask(name);
    }

    static void markTaskDone() {
        if (manager.isEmpty()) {
            System.out.println("  ℹ  Task list is empty. Nothing to mark.");
            return;
        }
        manager.viewAllTasks();
        int id = getIntInput("  Enter Task ID to mark as done: ");
        manager.markCompleted(id);
    }

    static void deleteTask() {
        if (manager.isEmpty()) {
            System.out.println("  ℹ  Task list is empty. Nothing to delete.");
            return;
        }
        manager.viewAllTasks();
        int id = getIntInput("  Enter Task ID to delete: ");

        // Confirmation before deleting
        System.out.print("  Are you sure you want to delete this task? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("yes") || confirm.equals("y")) {
            manager.deleteTask(id);
        } else {
            System.out.println("  ↩  Delete cancelled.");
        }
    }

    // ── UI Helpers ───────────────────────────────────────────────────────────

    static void printBanner() {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════╗");
        System.out.println("  ║       📚 Student Task Manager  v1.0      ║");
        System.out.println("  ║   Stay organized. Study smarter. 💪      ║");
        System.out.println("  ╚══════════════════════════════════════════╝");
        System.out.println();
    }

    static void printMenu() {
        System.out.println("  ┌──────────────────────────────────────────┐");
        System.out.println("  │               MAIN MENU                  │");
        System.out.println("  ├──────────────────────────────────────────┤");
        System.out.println("  │  1.  ➕  Add a Task                      │");
        System.out.println("  │  2.  ✅  Mark Task as Done               │");
        System.out.println("  │  3.  🗑  Delete a Task                   │");
        System.out.println("  │  4.  📋  View All Tasks                  │");
        System.out.println("  │  5.  ⏳  View Pending Tasks              │");
        System.out.println("  │  6.  📊  Show Summary                    │");
        System.out.println("  │  7.  🚪  Exit                            │");
        System.out.println("  └──────────────────────────────────────────┘");
    }

    // Safely reads an integer, handles bad input
    static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("  ⚠  Please enter a valid number.");
            }
        }
    }

    // Pause until the user hits Enter — gives them time to read output
    static void pause() {
        System.out.print("  Press Enter to continue...");
        scanner.nextLine();
        // clear screen feel with blank lines
        System.out.println("\n\n");
    }
}
