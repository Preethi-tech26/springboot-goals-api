# Spring Boot Goals API

A REST API built with Spring Boot and JPA/H2 to manage learning goals — built as a companion project to explore Java/Spring Boot after learning the same concepts in Python/FastAPI.

## Features
- Full CRUD (Create, Read, Update, Delete) for goals
- JPA/Hibernate ORM with H2 in-memory database
- RESTful endpoints following standard conventions

## Tech Stack
- Java 21
- Spring Boot 3.3
- Spring Data JPA
- H2 Database
- Maven

## Getting Started

### Prerequisites
- Java 21+
- Maven (or use the included wrapper `./mvnw`)

### Run the app
```bash
./mvnw spring-boot:run
```

Visit `http://localhost:8080` to confirm it's running.

## API Endpoints

| Method | Endpoint         | Description          |
|--------|------------------|------------------------|
| GET    | `/`              | Health check           |
| GET    | `/goals`         | Get all goals          |
| POST   | `/goals`         | Create a new goal       |
| PUT    | `/goals/{id}`    | Update a goal           |
| DELETE | `/goals/{id}`    | Delete a goal           |

## Database Console
View the H2 database directly at `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:goalsdb`
- Username: `sa`
- Password: (blank)

## About
Built as part of a self-directed learning project transitioning from QA/integration testing into backend development, exploring both Python (FastAPI) and Java (Spring Boot) stacks.