# URL Shortening Service

This project provides a URL shortening service using Java and Spring Boot. It allows users to shorten URLs (e.g., https://example.com/library/react) to a more compact form (e.g., http://short.est/GeAi9K) and retrieve the original URL using the shortened form.

## Requirements

- Java 17
- Maven

## Getting Started

These instructions will get your copy of the project up and running on your local machine for development and testing purposes.

### Setup

1. **Clone the repository:**
   git clone https://github.com/tkius123/urlshortening.git
   cd urlshortening
2. **Build the project:**

If you are using Maven, you can build the project using:

mvn clean install

This command will compile the project and run the unit tests.

### Running the Application

To run the application locally:

mvn spring-boot:run

This command will start the Spring Boot application. By default, it runs on `http://localhost:8080`.

## Usage

The application provides two main endpoints:

### 1. Encode URL

- **Endpoint:** `/encode`
- **Method:** POST
- **Description:** Accepts a URL and returns a shortened URL.
- **Request Example:**

curl -X POST 'http://localhost:8080/encode?url=https://example.com/library/react'

### 2. Decode URL

- **Endpoint:** `/decode`
- **Method:** GET
- **Description:** Accepts a shortened URL and returns the original URL.
- **Request Example:**

curl -X GET 'http://localhost:8080/decode?shortUrl=http://short.est/GeAi9K'

## Running Tests

To run tests, use the following command:

mvn test


This will execute all unit and integration tests in the project.

## Built With

- **Spring Boot (3.2.4)** - The framework used
- **Maven** - Dependency Management

## Author

- **Brian Hettiger** - *Initial work* - [tkius123](https://github.com/tkius123/yourusername)



