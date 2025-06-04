# Excel Uploader - Spring Boot Project

This Spring Boot application loads employee data from an Excel `.xlsx` file into an H2 in-memory database at application startup.

## ✅ Features

- Load Excel file (`employees.xlsx`) at startup
- Parse using Apache POI
- Save to in-memory H2 database
- View data via H2 Console
- Clean layered architecture
- MapStruct for DTO ↔ Entity conversion
- Centralized exception handling

---

## 🧱 Project Structure

src/
├── main/
│ ├── java/com/cloud/webapp/
│ │ ├── controller/ # (optional if REST added)
│ │ ├── service/ # Interfaces
│ │ ├── serviceimpl/ # Implementations
│ │ ├── repository/ # JpaRepository
│ │ ├── entity/ # JPA models
│ │ ├── DTO/ # Data Transfer Objects
│ │ ├── mapper/ # MapStruct mappers
│ │ ├── exceptions/ # Custom exception classes and handler
│ │ ├── utils/ # Excel parsing logic
│ │ ├── bootstrap/ # ApplicationRunner to trigger load
│ │ └── WebappApplication.java
│ └── resources/
│ ├── employees.xlsx # Excel file to load
│ └── application.properties


---

## ▶️ How It Works

1. On application startup, `DataLoaderRunner` is triggered.
2. It reads `employees.xlsx` using `ExcelParserUtil`.
3. Rows are mapped to `EmployeeDTO` objects.
4. DTOs are converted to `EmployeeEntity` using MapStruct.
5. Records are saved into H2 DB using Spring Data JPA.

---

## 🛠️ Setup & Run

### Prerequisites

- Java 17+
- Maven
- IntelliJ or any IDE with Spring support

### Run the App

Or from IntelliJ:

Right-click WebappApplication.java → Run

---

## View Inserted Data (H2 Console)
1. Go to: http://localhost:8080/h2-console
2. Use these credentials:
    - JDBC URL: jdbc:h2:mem:testdb 
    - Username: sa 
    - Password: (leave blank)
3. Run:
    - SELECT * FROM employees;

## Tech Stack
    - Spring Boot 3.5.x
    - Java 17
    - Apache POI
    - H2 Database
    - MapStruct
    - Lombok

## Example Excel Format (employees.xlsx)

| name  | department | joiningDate | salary |
| Alice | HR         | 2021-06-01  | 65000  |
| Bob   | IT         | 2022-01-15  | 85000  |

## Make sure this file exists at:
    - src/main/resources/employees.xlsx
