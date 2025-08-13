# 📌 Leave Management System (LMS)

A simple **Spring Boot** project for managing employees, leave requests, and authentication with **PostgreSQL** database support.

---------------------------------------------------------------------------------------------------------------------

## 🚀 Getting Started

### 1️⃣ **Unzip the Project**
Download and unzip the project folder.

----------------------------------------------------------------------------------------------------------------------

### 2️⃣ **Open in an IDE**
Open the project in any Java IDE (preferably **IntelliJ IDEA**).

------------------------------------------------------------------------------------------------------------------------

### 3️⃣ **Setup PostgreSQL Database**
You can set up the database in one of two ways:

#### Option 1 – Using DBeaver
- Create a new database named `lms`.
- Replace the database name, username, and password in `application.properties` if needed.

#### Option 2 – Using Docker
Run PostgreSQL with Docker:
```bash
docker run --name postgres-lms -e POSTGRES_PASSWORD=1234 -e POSTGRES_DB=lms -p 5432:5432 -d postgres

--------------------------------------------------------------------------------------------------------------------------
4️⃣ Update Database Credentials
Modify the following in src/main/resources/application.properties if required:
spring.datasource.url=jdbc:postgresql://localhost:5432/lms
spring.datasource.username=postgres
spring.datasource.password=1234

Run the Application
Locate the main method in your Spring Boot application class.

---------------------------------------------------------------------------------------------------------------------------


🛠 Lombok Note
The Lombok dependency is already included in the project.
Lombok helps in auto-generating boilerplate code such as getters, setters, constructors, and toString() methods through simple annotations.

In this project, getters and setters are manually written instead of using Lombok annotations, so the code will work in any situation.

⚠ Note: IF YOU REPLACE AND USE LOMBOK ANNOTATION KINDLY NOTE -  Sometimes, Lombok gives Annotation Processing error.


-----------------------------------------------------------------------------------------------------------------------------

🔧 Change Default Leave Balance
Default leave balance is 12.

To change it, edit: 
src/main/java/com/lms/lms/services/AuthService.java

Look for:
private static final int LEAVE_BALANCE = 12;

🔐 JWT Secret
jwt.secret=asdnkasndkaskndnasndlaslksadiaskldnkasnkldklasbkd

-----------------------------------------------------------------------------------------------------------------------------

⚙ Project Configuration
Database Config (PostgreSQL)

spring.datasource.url=jdbc:postgresql://localhost:5432/lms
spring.datasource.username=postgres
spring.datasource.password=1234
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jackson.serialization.fail-on-empty-beans=false
spring.jpa.properties.hibernate.cache.use_second_level_cache=false
spring.jpa.properties.hibernate.cache.use_query_cache=false
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always


