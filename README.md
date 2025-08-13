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

-------------------------------------------------------------------------------------------------------------------------------------------

All Implemented Edge Cases

🔐 Authentication & Authorization (8)
User not found by email

Employee profile missing for authenticated user

Invalid user role

Insufficient permissions for on-behalf applications

Employee trying to access other employee's data

Non-HR user trying to access HR-only features

Target employee not found (when applying for others)

Self-access validation failure

📅 Date Validation (7)
Start date is null

End date is null

End date before start date

Applying for past dates

Leave before employee joining date

Leave application more than 1 year in advance

Approving leave for past dates

💰 Leave Balance (4)
Insufficient leave balance during application

Leave balance changed between application and approval

Pending leaves exceeding available balance

Available balance calculation with pending requests

📝 Leave Request Overlap (6)
Overlapping with pending leave requests

Overlapping with approved leave requests

Date range overlap detection algorithm

Detailed overlap error messages

Multiple overlapping leave request checking

Combined active leaves validation

🔄 Leave Status & Workflow (5)
Processing already processed leave request

Leave request not found by ID

Cancelling non-approved leave

Cancelling already started leave

Cancelling leave starting today



-------------------------------------------------------------------------------------------------------------------------------------

Business Logic Assumptions:

✅ Leave Balance: All employees start with 12 days annually (configurable via properties)

✅ Leave Types: Single generic leave type (no categorization like sick, vacation, personal)

✅ Approval Workflow: Single-level approval system (HR approves all requests)

✅ Working Days: All calendar days count as working days (no weekend/holiday exclusions)

✅ Leave Year: Calendar year basis (January to December cycle)

✅ Carry Forward: No unused leave carry-over to next year

✅ Application Timing: Can apply up to 1 year in advance, no past dates

✅ Partial Days: Only full-day leaves supported (no half-day options)

✅ Leave Restoration: Cancelled approved leaves restore full balance

Technical Assumptions:

✅ Single Tenant: One organization/company per deployment

✅ User Roles: Only two roles (EMPLOYEE, HR) - no managers/supervisors

✅ Authentication: JWT tokens with 10-minute expiration

✅ Database: H2 for development, easily switchable to MySQL/PostgreSQL

✅ Timezone: Single timezone application (no multi-timezone support)

✅ Concurrency: Basic transaction management (optimistic locking assumed)

✅ File Storage: No document attachments for leave requests

✅ Email Integration: No automated email notifications

-------------------------------------------------------------------------------------------------------------------------------------------

✅ Potential Improvement:

Security:
 Refresh tokens
 Password validation

Features:
 Pagination
 Multiple leave types
 File upload
 Leave calendar
 Half-day leaves
 Export to PDF/Excel

Communication
 Add email notifications
 SMS integration

Performance
 Redis caching
 Database indexing




