# tg_user_service

## Table of Contents

1. [Introduction](#introduction)
2. [Technologies Used](#technologies-used)
3. [Installation and Setup](#installation-and-setup)
4. [API Endpoints](#api-endpoints)
5. [Testing](#testing)
6. [Error Handling](#error-handling)
7. [Contributing](#contributing)
8. [License](#license)

## Introduction

This project is a user service for a tour guide application. It provides endpoints for user creation, authentication, and administration.

## Technologies Used

This project is implemented using the following technologies:

```
- Java
- Spring Boot
- Maven
```

## Installation and Setup

## Installation and Setup

To setup the `tg_user_service` project for local development, follow these steps:

1. **Install Java**

   The project requires Java 20 (as specified in the pom.xml file). If you haven't installed it yet, please download and install it from the official Oracle website or use a package manager like `apt` or `brew` depending on your OS.

2. **Install MySQL**

   As per the `application.properties` file, the project uses a MySQL database. Install MySQL server on your machine if not installed already. After installing, create a database named `tg_user`. 

3. **Set up the Database**

   The `application.properties` file suggests that the username for the MySQL server is 'root' and the password is 'stick4xbox370'. You may need to change these values if your MySQL server has a different username/password.

4. **Install Maven**

   The project is a Maven project, so you'll need to have Maven installed. Download and install it from the official Apache Maven website or use a package manager like `apt` or `brew` depending on your OS.

5. **Clone the Repository**

   Clone the repository to your local machine using the following command: 
   ``` bash
   git clone https://github.com/Huakus/tg_user_service.git
   ```
   
6. **Build the Project**

   Navigate into the cloned repository and run the following command to build the project:
   ``` bash
   mvn clean install
   ```
   This command cleans the project, compiles the source code, runs any tests, and packages the compiled code into a JAR file.

7. **Run the Project**

   After the build is successful, run the following command to start the service:
   ``` bash
   java -jar target/user-0.0.1-SNAPSHOT.jar
   ```
   The project should start and be available on port 8081 as specified in the `application.properties` file.

Please ensure that you have the necessary permissions to install and run these services on your machine. If you encounter any errors during this process, they are likely due to environment-specific issues and you may need to troubleshoot accordingly.


## API Endpoints

Here are some of the endpoints in the application:

```
1. HTTP verb: GET, Endpoint: /users
   - Explanation: Get all users.
   - Parameters: None
   - Sample Request: GET /users
   - Sample Response: [array of User objects]

2. HTTP verb: GET, Endpoint: /users/{id}
   - Explanation: Get a user by ID.
   - Parameters: ID (path variable)
   - Sample Request: GET /users/1
   - Sample Response: User object or 404 error

(Other endpoints are also available but need to be documented)
```

## Testing

Details on how to run tests for this API are not available in the codebase.

```
Commands to run the tests and any necessary setup.
```

## Error Handling

The application handles errors by returning appropriate HTTP status codes. For example, if a user is not found, it returns a 404 status code.

```
Explanation of error handling.
```

## Contributing

Details on how others can contribute to the project are not provided in the codebase.

## License

The license information for the project is not provided in the codebase.
