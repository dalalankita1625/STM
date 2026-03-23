/**
 * Task.java
 * Represents a single study task with an ID, name, and completion status.
 * Author: Student Project
 */
public class Task {

    private int id;
    private String name;
    private boolean completed;

    // Constructor
    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.completed = false; // every new task starts as pending
    }

    // --- Getters & Setters ---

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // Displays status as a readable string
    public String getStatus() {
        return completed ? "✔ Done" : "⏳ Pending";
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name + "  —  " + getStatus();
    }
}
