# REST-API-Kotlin-Spring

Description: This is a REST API project built using Spring Boot and Kotlin.

**Database Schema:**

![image](https://github.com/user-attachments/assets/72a5b4f3-a074-436c-9f08-d991184bc2f5)


**Features:**


**CategoryController Endpoints:**

Method: GET /categories - get a list of all categories.

Method: GET /categories/{id} - get a category by category's ID

Method: GET /categories/search - searches for categories whose names start with the given prefix.

Method: GET /categories/list - get a list of category names only, without additional details.

Method: POST /categories - creates a new category with the provided details.

Method: PUT /categories/{id} - updates the details of an existing category by its ID.

Method: DELETE /categories/{id} - deletes an existing category by its ID.


**Product Controller Endpoints:**

Method: GET /products - get a list of all products.

Method: GET /products/{id} - get a product by product's ID

Method: GET /products/search - searches for products whose names start with the given prefix.

Method: POST /products - creates a new product with the provided details.

Method: PUT /products/{id} - updates the details of an existing product by its ID.

Method: DELETE /products/{id} - deletes an existing product by its ID.


Schedule task: Price Update

Cron Expression: 0 0 0 * * ? (Runs at midnight every day)

This scheduled task automatically increases the price of every product by 1 unit at midnight each day.


**Application Profiles:**

**Development Profile (application-dev.yml)**

Database Configuration:


Driver Class: org.h2.Driver - Uses the H2 in-memory database for development.

URL: jdbc:h2:file:./data/testdb - Specifies the location of the database file.

Username: sa - Default username for H2 database.

Password: No password is set for the H2 database.

Connection Init SQL: dataH2.sql - SQL script to be executed on initialization.

**Production Profile (application-prod.yml)**

Database Configuration:

Driver Class: org.postgresql.Driver - Uses PostgreSQL as the database in production.

URL: jdbc:postgresql://localhost:5432/postgres - Specifies the connection URL for the PostgreSQL database.

Username: myuser - The username to connect to the PostgreSQL database.

Password: mypassword - The password for the specified user.

Connection Init SQL: data.sql - SQL script to be executed on initialization.
