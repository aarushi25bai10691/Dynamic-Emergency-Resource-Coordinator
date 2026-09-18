# Dynamic-Emergency-Resource-Coordinator

# CrisisRelief: Emergency Resource Coordinator 🚨

### Submitted by: Aarushi Chauhan | 25BAI10691

## 📖 Project Overview

This is a Java-based application developed for the course project. It functions as an Emergency Resource Allocation System that prioritizes and dispatches essential supplies (medical kits, clean water, shelter gear) to high-urgency crisis zones during natural disasters. In addition to the core dispatch engine, this repository includes five interactive CLI field utilities that demonstrate Object-Oriented Programming (OOP), dynamic priority sorting, and robust input validation to solve real-world disaster relief logistics bottlenecks.

## ✨ Features

* **SOS Request Logging:** Captures emergency requests with category, location, urgency level, severity index, and waiting time.
* **Warehouse Stock Tracker:** Manages inventory levels across regional distribution hubs.
* **Dynamic Priority Scoring Engine:** Calculates weighted priority scores using urgency, elapsed waiting time, and regional severity.
* **Automated Dispatch:** Pairs highest-priority requests with available warehouse inventory and auto-deducts stock.
* **Interactive Field Tools:** Includes 5 interactive utilities for real-time priority scoring (`SosPriorityAssessor`), warehouse management (`InventoryManager`), triage supply planning (`TriageSupplyEstimator`), evacuation fleet calculations (`EvacuationCalculator`), and priority threshold alert filtering (`PriorityFilterTool`).
* **Dashboard Reporting:** Prints detailed inventory summaries and request statuses before and after dispatch runs.

## 📂 Project Structure

The project follows a clean structure for easy execution and maintainability:

* `src/`
* `Main.java`: Main entry point containing data models (`SosRequest`, `ReliefInventory`), business logic (`ReliefService`), and core dispatch execution commands.
* `SosPriorityAssessor.java`: Interactive tool for assessing individual request priority scores from field input.
* `InventoryManager.java`: Menu-driven system to view, add, and deduct warehouse stock in real time.
* `TriageSupplyEstimator.java`: Tool for calculating medical supply needs based on patient triage tag counts.
* `EvacuationCalculator.java`: Fleet logistics tool calculating transport trips, total distance, and fuel needs.
* `PriorityFilterTool.java`: Utility to filter incoming emergency alerts against custom priority threshold scores.


* `assets/`: Contains project screenshots and execution logs.
* `statement.md`: Detailed problem statement, scope, target users, and functional requirements.
* `README.md`: Detailed documentation and setup instructions.

## 🛠️ Technology Stack

* **Language:** Java 17+
* **Concepts Used:** Object-Oriented Programming (OOP), `ArrayList`, Sorting Algorithms / Comparators, Data Encapsulation, Interactive CLI / `java.util.Scanner` Input Validation.

## 🚀 Steps to Install & Run

### Method 1: Local Command Line

1. Clone the repository to your local machine.
2. Navigate to the `src` directory:

```bash
cd src

```

3. Compile the Java source files:

```bash
javac Main.java

```

4. Run the main engine or any interactive utility:

```bash
java Main

```

*(To run an interactive tool, use `java InventoryManager`, `java SosPriorityAssessor`, etc.)*

### Method 2: Programiz / Online Compiler

1. Open the [Programiz Online Java Compiler](https://www.programiz.com/java-programming/online-compiler/).
2. Paste the entire content of `Main.java` (or any single-file interactive utility script) into the code editor.
3. Click **Run** to execute the program.

## ✔️ Instructions for Testing

To verify the priority dispatch logic and interactive tools, observe the system output for these scenarios:

1. **High Priority Test:** SOS Request with Urgency = 9, Severity = 8 (Expected: Dispatched first in priority queue).
2. **Low Priority Test:** SOS Request with Urgency = 5, Severity = 4 (Expected: Dispatched after higher urgency items).
3. **Out-of-Stock Test:** Request an item category with 0 inventory count (Expected: Request remains in `"OPEN"` status without throwing errors).
4. **Interactive CLI Boundary Test:** Enter invalid menu choices or non-numeric input in tools like `InventoryManager` or `PriorityFilterTool` (Expected: Input validation guard catches error and reprompts gracefully).
5. **Threshold Filter Test:** Set threshold score to 5.0 in `PriorityFilterTool` (Expected: Only alerts with priority score ≥ 5.0 are displayed for dispatch).

## 📸 Screenshots

*(Screenshots are available in the /assets folder)*
