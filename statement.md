# Problem Statement & Scope

## 1. Problem Statement

During natural disasters like floods or earthquakes, emergency relief agencies struggle to allocate limited inventory (medical kits, water, shelter gear) efficiently. Manual allocation leads to severe bottlenecks and improper prioritization, leaving high-urgency crisis zones waiting while lower-priority requests are fulfilled out of order. Furthermore, field responders and warehouse operators often lack interactive, lightweight tools to quickly assess triage needs, filter critical alerts, and calculate evacuation fleet logistics on the ground.

## 2. Scope of the Project

This project is an **Emergency Resource Allocation System** that:

* Collects emergency SOS request data (urgency rating, regional severity, location, waiting time) and warehouse stock levels.
* Applies a weighted priority scoring algorithm to dynamically rank pending emergency requests and prevent resource starvation.
* Matches highest-priority requests to available inventory, updates stock counts automatically, and displays status dashboards.
* Provides interactive command-line utilities for field triage supply estimation, evacuation fleet fuel planning, real-time stock adjustments, and high-priority alert filtering.

## 3. Target Users

* Field Emergency Responders logging urgent community requests and performing quick priority assessments in disaster zones.
* Relief Warehouse Managers monitoring real-time stock levels, adding restocks, and executing supply dispatches.
* Disaster Response Coordinators reviewing priority queues, filtering critical alert thresholds, and planning evacuation fleet logistics.

## 4. High-Level Features

* **SOS Request Logging & Assessment:** Captures emergency requests specifying item category, location, urgency level, and severity index, supported by an interactive CLI tool for quick field priority calculations.
* **Warehouse Stock Management:** Tracks real-time inventory counts across distribution hubs with an interactive menu to check, add, and deduct stock on demand.
* **Dynamic Priority Scoring:** Computes priority scores continuously based on urgency, regional severity, and elapsed waiting time using a weighted mathematical formula.
* **Automated Dispatch Engine:** Pairs highest-priority requests with available warehouse stock and auto-deducts inventory safely.
* **Triage & Logistics Utilities:** Includes standalone utilities for medical triage supply estimation, refugee evacuation vehicle/fuel planning, and custom threshold-based alert queue filtering.
