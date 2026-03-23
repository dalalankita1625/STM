# 📚 Student Task Manager

A simple console-based Java application to help students manage their daily study tasks.
Built with plain Java — no extra libraries needed.

---

## ✨ Features

| Feature | Description |
|---|---|
| ➕ Add Task | Add a new study task (duplicate check included) |
| ✅ Mark Done | Mark a task as completed with a celebration message |
| 🗑 Delete Task | Delete a task with a confirmation prompt |
| 📋 View All | See all tasks with their current status |
| ⏳ View Pending | See only tasks that are not yet done |
| 📊 Summary | Quick stats — total, completed, and pending tasks |

---

## 🛠 How to Run

Make sure you have **Java 17+** installed.

```bash
# Step 1: Navigate to the project folder
cd StudentTaskManager

# Step 2: Compile all three files
javac Task.java TaskManager.java Main.java

# Step 3: Run the program
java Main
```

---

## 📁 Project Structure

```
StudentTaskManager/
├── Task.java          → Model class (id, name, status)
├── TaskManager.java   → Business logic (add, delete, complete, view)
├── Main.java          → Entry point + user interaction menu
└── README.md          → You're reading it!
```

---

## 💡 OOP Concepts Used

- **Encapsulation** — Task fields are private with getters/setters
- **Classes & Objects** — `Task`, `TaskManager`, `Main` each have a clear role
- **ArrayList** — Used for in-memory task storage
- **Methods** — Logic is neatly separated into meaningful methods

---

## 🖥 Sample Output

```
  ╔══════════════════════════════════════════╗
  ║       📚 Student Task Manager  v1.0      ║
  ║   Stay organized. Study smarter. 💪      ║
  ╚══════════════════════════════════════════╝

  ┌──────────────────────────────────────────┐
  │               MAIN MENU                  │
  ├──────────────────────────────────────────┤
  │  1.  ➕  Add a Task                      │
  │  2.  ✅  Mark Task as Done               │
  │  3.  🗑  Delete a Task                   │
  │  4.  📋  View All Tasks                  │
  │  5.  ⏳  View Pending Tasks              │
  │  6.  📊  Show Summary                    │
  │  7.  🚪  Exit                            │
  └──────────────────────────────────────────┘
```

---

## 🙋 About

Made as a personal study tool. It's simple, but it gets the job done!
