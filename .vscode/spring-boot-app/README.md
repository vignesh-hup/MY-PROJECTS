# Spring Boot Application

This is a simple Spring Boot application created using Gradle.

## Project Structure

```
spring-boot-app
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── SpringBootAppApplication.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── SpringBootAppApplicationTests.java
├── build.gradle
├── settings.gradle
└── README.md
```

## Prerequisites

- Java 11 or higher
- Gradle 6.0 or higher

## Building the Application

To build the application, navigate to the project directory and run:

```
./gradlew build
```

## Running the Application

To run the application, use the following command:

```
./gradlew bootRun
```

## Running Tests

To run the tests, execute:

```
./gradlew test
```

## Configuration

You can configure the application by modifying the `src/main/resources/application.properties` file. 

