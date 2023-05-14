# codegpt-server
It's backend server of [ChatGPT UI](https://github.com/lancerzhang/codegpt-ui)

## Features
- [x] OAuth 2 SSO authentication and authorization
- [x] Forwarding requests to OpenAI API with credentials

## Prerequisites

- JDK 1.8 or later
- Maven 3.2 or later
- An IDE like IntelliJ or Eclipse

## Running the Application

To run the application, execute the following command in the terminal:
```shell
mvn spring-boot:run
```

The application will start running at `http://localhost:8080`.