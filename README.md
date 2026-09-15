# Dynamic-Emergency-Resource-Coordinator

# CrisisRelief: Emergency Resource Coordinator 🚨

### Submitted by: [Aarushi Chauhan] | [25BAI10691]

## 📖 Project Overview

This is a Java-based application developed for the course project. It functions as an Emergency Resource Allocation System that prioritizes and dispatches essential supplies (medical kits, clean water, shelter gear) to high-urgency crisis zones during natural disasters. This project demonstrates the use of Object-Oriented Programming (OOP), data structures, and dynamic priority sorting to solve a real-world disaster relief bottleneck.

## ✨ Features

* **SOS Request Logging:** Captures emergency requests with category, location, urgency level, severity index, and waiting time.


* **Warehouse Stock Tracker:** Manages inventory levels across regional distribution hubs.


* **Dynamic Priority Scoring Engine:** Calculates weighted priority scores using urgency, elapsed waiting time, and regional severity.
* **Automated Dispatch:** Pairs highest-priority requests with available warehouse inventory and auto-deducts stock.


* **Dashboard Reporting:** Prints detailed inventory summaries and request statuses before and after dispatch runs.



## 📂 Project Structure

The project follows a clean structure for easy execution and maintainability:

* `src/`
* `Main.java`: Main entry point containing data models (`SosRequest`, `ReliefInventory`), business logic (`ReliefService`), and system execution commands.


* `assets/`: Contains project screenshots and execution logs.
* `statement.md`: Detailed problem statement, scope, target users, and functional requirements.


* `README.md`: Detailed documentation and setup instructions.



## 🛠️ Technology Stack

* **Language:** Java 17+


* **Concepts Used:** Object-Oriented Programming (OOP), `ArrayList`, Sorting Algorithms / Comparators, Data Encapsulation.

## 🚀 Steps to Install & Run

### Method 1: Local Command Line

1. Clone the repository to your local machine.
2. Navigate to the `src` directory:
```bash
cd src

```


3. Compile the Java source file:
```bash
javac Main.java

```


4. Run the application:
```bash
java Main

```



### Method 2: Programiz / Online Compiler

1. Open the [Programiz Online Java Compiler](https://www.programiz.com/java-programming/online-compiler/).
2. Paste the entire content of `Main.java` into the code editor.
3. Click **Run** to execute the program.

## ✔️ Instructions for Testing

To verify the priority dispatch logic, you can observe the system console output for these scenarios:

1. **High Priority Test:** SOS Request with Urgency = 9, Severity = 8 (Expected: Dispatched first in priority queue).


2. **Low Priority Test:** SOS Request with Urgency = 5, Severity = 4 (Expected: Dispatched after higher urgency items).


3. **Out-of-Stock Test:** Request an item category with 0 inventory count (Expected: Request remains in `"OPEN"` status without throwing errors).



## 📸 Screenshots

*(Screenshots are available in the /assets folder)*
