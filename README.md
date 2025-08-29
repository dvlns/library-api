# Library API

This project is a RESTful API for a library management system, built with Spring Boot. It provides functionality to manage users, books, and loans.

## Features

- **User Management**: Create, list, and delete library users.
- **Book Management**: Add, list, and delete books from the library catalog.
- **Loan System**: Create new loans for users with multiple books, mark loans as returned, and list all loans.
- **Database Migrations**: Uses Flyway to manage database schema evolution.

## Technologies Used

- **Framework**: Spring Boot 3
- **Language**: Java 17
- **Database**: PostgreSQL
- **Data Access**: Spring Data JPA
- **Database Migration**: Flyway
- **Build Tool**: Maven
- **Utilities**: Lombok

## Prerequisites

- JDK 17 or later
- Maven
- A running PostgreSQL instance

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/dvlns/library-api.git
cd library-api
```

### 2. Configure the Database

Open the `src/main/resources/application.properties` file and update the database connection details to match your local PostgreSQL setup.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
spring.datasource.username=postgres
spring.datasource.password=post
```

You will need to create a database named `library_db` (or whatever you configure in the properties file).

### 3. Run the Application

Use the Maven wrapper to run the application. Flyway will automatically run the database migrations on startup.

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Endpoints

### Users

#### `GET /users`
Retrieves a list of all users.

**Example cURL:**
```bash
curl -X GET http://localhost:8080/users
```

#### `POST /users`
Creates a new user.

**Example cURL:**
```bash
curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{
    "name": "Jane Doe",
    "email": "jane.doe@example.com"
}'
```

#### `DELETE /users/{id}`
Deletes a user by their ID.

**Example cURL:**
```bash
curl -X DELETE http://localhost:8080/users/1
```

### Books

#### `GET /books`
Retrieves a list of all books.

**Example cURL:**
```bash
curl -X GET http://localhost:8080/books
```

#### `POST /books`
Adds a new book to the catalog.

**Example cURL:**
```bash
curl -X POST http://localhost:8080/books \
-H "Content-Type: application/json" \
-d '{
    "title": "Clean Code",
    "author": "Robert C. Martin",
    "ISBN": "9780132350884"
}'
```

#### `DELETE /books/{id}`
Deletes a book by its ID.

**Example cURL:**
```bash
curl -X DELETE http://localhost:8080/books/1
```

### Loans

#### `GET /loans`
Retrieves a list of all loans, including details of the user and books.

**Example cURL:**
```bash
curl -X GET http://localhost:8080/loans
```

#### `POST /loans`
Creates a new loan for a user with one or more books. The loan date is set to the current date.

**Example cURL:**
```bash
curl -X POST http://localhost:8080/loans \
-H "Content-Type: application/json" \
-d '{
    "userId": 1,
    "bookIds": [1, 2]
}'
```

#### `PUT /loans/{id}/return`
Marks an existing loan as returned and sets the return date to the current date.

**Example cURL:**
```bash
curl -X PUT http://localhost:8080/loans/1/return
