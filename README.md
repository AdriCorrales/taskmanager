# TaskManager by Adrián Corrales
This project is being built with Spring Boot, through which tasks and information from various users are managed via a REST API.

## Technologies
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security (Basic Auth)
- MySQL (Docker)
- Hibernate
- Maven

## Prerequisites
To run this project, you need:
- Java + IDE
- MySQL
- Docker Desktop

## How to run the project
1. Start MySQL in Docker  
`docker run --detach --env MYSQL_ROOT_PASSWORD=taskpassword --env MYSQL_USER=tasks-user --env MYSQL_PASSWORD=taskpassword --env MYSQL_DATABASE=tasks-database --name tasks-mysql --publish 3306:3306 mysql:8-oracle`

2. In case you are using MySQL Shell, you should follow these commands:  
`\connect tasks-user@localhost:3306`  
`\use tasks-database`  
`\sql`  

3. Run the API  
`./mvnw spring-boot:run`

## Endpoints

In `/postman` folder you can find a Postman collection with the following endpoints:

### Users
`GET /users`  
`POST /users`  
`GET /users/{id}`  
`DELETE /users/{id}`  
`PUT /users/{id}`

### Tasks 
`GET /tasks`
`GET /tasks/{id}`  
`GET /users/{id}/tasks`  
`GET /users/{id}/tasks/{id}`  
`POST /users/{id}/tasks`  
`DELETE /tasks/{id}`  
`PUT /tasks/{id}`