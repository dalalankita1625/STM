import java.util.ArrayList;

/**
 * TaskManager.java
 * Handles all operations: add, delete, complete, view tasks.
 * Uses an ArrayList to store tasks in memory.
 */
public class TaskManager {

    private ArrayList<Task> taskList;
    private int nextId; // auto-increment ID for each task

    public TaskManager() {
        taskList = new ArrayList<>();
        nextId = 1;
    }

    // Add a new task (prevents duplicates, case-insensitive)
    public boolean addTask(String name) {
        String trimmed = name.trim();

        if (trimmed.isEmpty()) {
            System.out.println("  ⚠  Task name can't be empty!");
            return false;
        }

        // Check for duplicate
        for (Task t : taskList) {
            if (t.getName().equalsIgnoreCase(trimmed)) {
                System.out.println("  ⚠  \"" + trimmed + "\" already exists in your list.");
                return false;
            }
        }

        taskList.add(new Task(nextId++, trimmed));
        System.out.println("  ✅  Task added successfully!");
        return true;
    }

    // Mark a task as completed by ID
    public boolean markCompleted(int id) {
        Task task = findById(id);
        if (task == null) {
            System.out.println("  ⚠  No task found with ID " + id);
            return false;
        }
        if (task.isCompleted()) {
            System.out.println("  ℹ  This task is already marked as done.");
            return false;
        }
        task.setCompleted(true);
        System.out.println("  🎉  Good job! \"" + task.getName() + "\" marked as completed!");
        return true;
    }

    // Delete a task by ID
    public boolean deleteTask(int id) {
        Task task = findById(id);
        if (task == null) {
            System.out.println("  ⚠  No task found with ID " + id);
            return false;
        }
        taskList.remove(task);
        System.out.println("  🗑  Task \"" + task.getName() + "\" deleted.");
        return true;
    }

    // View all tasks
    public void viewAllTasks() {
        if (taskList.isEmpty()) {
            System.out.println("  📭  No tasks yet. Add some study tasks to get started!");
            return;
        }
        System.out.println("\n  ── All Tasks ──────────────────────────────");
        for (Task t : taskList) {
            System.out.println("  " + t);
        }
        System.out.println("  ───────────────────────────────────────────");
    }

    // View only pending tasks
    public void viewPendingTasks() {
        boolean found = false;
        System.out.println("\n  ── Pending Tasks ──────────────────────────");
        for (Task t : taskList) {
            if (!t.isCompleted()) {
                System.out.println("  " + t);
                found = true;
            }
        }
        if (!found) {
            System.out.println("  🎊  No pending tasks! You're all caught up.");
        }
        System.out.println("  ───────────────────────────────────────────");
    }

    // Show summary
    public void showSummary() {
        int total = taskList.size();
        int completed = 0;
        for (Task t : taskList) {
            if (t.isCompleted()) completed++;
        }
        int pending = total - completed;

        System.out.println("\n  ── Summary ────────────────────────────────");
        System.out.println("  📋  Total Tasks   : " + total);
        System.out.println("  ✅  Completed     : " + completed);
        System.out.println("  ⏳  Pending       : " + pending);
        System.out.println("  ───────────────────────────────────────────");
    }

    // Helper: find a task by ID
    private Task findById(int id) {
        for (Task t : taskList) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    // Check if task list is empty (used before asking for IDs)
    public boolean isEmpty() {
        return taskList.isEmpty();
    }
}
