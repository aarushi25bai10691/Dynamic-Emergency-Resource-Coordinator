# Problem Statement & Scope

## 1. Problem Statement

During natural disasters like floods or earthquakes, emergency relief agencies struggle to allocate limited inventory (medical kits, water, shelter gear) efficiently. Manual allocation leads to severe bottlenecks and improper prioritization, leaving high-urgency crisis zones waiting while lower-priority requests are fulfilled out of order.

## 2. Scope of the Project

This project is an **Emergency Resource Allocation System** that:

* Collects emergency SOS request data (urgency rating, regional severity, location, waiting time) and warehouse stock levels.


* Applies a weighted priority scoring algorithm to dynamically rank pending emergency requests.
* Matches highest-priority requests to available inventory, updates stock counts automatically, and displays status dashboards.



## 3. Target Users

* Field Emergency Responders logging urgent community requests from disaster zones.


* Relief Warehouse Managers monitoring stock levels and managing dispatch inventory.


* Disaster Response Coordinators reviewing priority queues and supply summary reports.



## 4. High-Level Features

* **SOS Request Logging:** Captures emergency requests specifying item category, location, urgency level, and severity index.


* **Warehouse Stock Management:** Tracks and manages real-time inventory counts across distribution hubs.


* **Dynamic Priority Scoring:** Computes priority scores continuously based on urgency, regional severity, and elapsed waiting time.
* **Automated Dispatch Engine:** Pairs highest-priority requests with available warehouse stock and auto-deducts inventory.
