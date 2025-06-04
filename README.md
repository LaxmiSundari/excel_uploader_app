# 📊 Excel Uploader - Spring Boot Project

This Spring Boot application loads employee data from an Excel `.xlsx` file into an in-memory H2 database during application startup.

---

## ✅ Features

- ⏱️ Auto-load Excel data at startup
- 📄 Apache POI-based Excel parsing
- 🧠 Clean layered architecture
- 🎯 MapStruct-based DTO ↔ Entity mapping
- 🛡️ Centralized exception handling
- 🗃️ View data using H2 Console

---

## 🧱 Project Structure

```plaintext
src
├── main
│   ├── java
│   │   └── com.cloud.webapp
│   │       ├── WebappApplication.java       # Spring Boot entry point
│   │       ├── bootstrap
│   │       │   └── DataLoaderRunner.java    # Loads Excel at startup
│   │       ├── DTO
│   │       │   ├── EmployeeDTO.java
│   │       │   └── ResponseDTO.java
│   │       ├── entity
│   │       │   └── EmployeeEntity.java      # JPA model
│   │       ├── exceptions
│   │       │   ├── GlobalExceptionHandler.java
│   │       │   └── Types
│   │       │       └── GeneralServiceException.java
│   │       ├── mapper
│   │       │   └── EmployeeMapper.java
│   │       ├── repository
│   │       │   └── EmployeeRepository.java
│   │       ├── service
│   │       │   └── EmployeeService.java
│   │       ├── serviceimpl
│   │       │   └── EmployeeServiceImpl.java
│   │       └── utils
│   │           └── ExcelParserUtil.java     # Apache POI-based Excel reader
│   └── resources
│       ├── application.properties           # H2 and JPA config
│       └── employees.xlsx                   # Input file to be loaded
```

---

## ▶️ How to Run

### 🖥️ Prerequisites
- Java 17+
- Gradle
- IntelliJ or compatible IDE

### 🚀 Launch

In IntelliJ:
> Right-click `WebappApplication.java` → Run

---

## 🔎 View Data in H2 Console

1. Open: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
2. JDBC URL: `jdbc:h2:mem:testdb`
3. Username: `sa`
4. Password: *(leave blank)*
5. Run:
   ```sql
   SELECT * FROM employees;
   ```

---

## 📄 Example Excel Format (`employees.xlsx`)

| name   | department | joiningDate | salary  |
|--------|------------|-------------|---------|
| Alice  | HR         | 2021-06-01  | 65000.0 |
| Bob    | IT         | 2022-01-15  | 85000.0 |

> Place this file inside `src/main/resources`.

---

## 💡 Technologies Used

- Spring Boot 3.5.x
- Java 17
- H2 Database
- Apache POI
- Lombok
- MapStruct

---

## 🙋 Author

Designed with clean architecture principles, this project separates concerns using DTOs, services, mappers, repositories, and centralized exception handling. Ideal for onboarding and real-world enterprise bootstrapping tasks.
