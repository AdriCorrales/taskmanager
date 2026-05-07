# TaskManager by Adrián Corrales
Este es un proyecto realizado con Springboot, mediante el cual se gestionan las tareas e información de diversos usuarios, mediante una API REST.

## Tecnologías usadas
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security (Basic Auth)
- MySQL (Docker)
- Hibernate
- Maven

## Prerequisitos
Para poder ejecutar este proyecto se necesita: 
- Java + IDE
- MySQL
- Docker Desktop

## Cómo ejecutar el proyecto
1. Levantar MySQL en Docker
docker run --detach --env MYSQL_ROOT_PASSWORD=taskpassword --env MYSQL_USER=tasks-user --env MYSQL_PASSWORD=taskpassword --env MYSQL_DATABASE=tasks-database --name tasks-mysql --publish 3306:3306 mysql:8-oracle

2. En caso que se use MySQL Shell, hay que seguir los siguientes comandos:
- \connect tasks-user@localhost:3306
- \use tasks-database
- \sql

3. Ejecutar la API
./mvnw spring-boot:run

## Endpoints

En la carpeta /postman se puede encontrar una colección de Postman con los siguientes endpoints:

### Users
- GET /users
- POST /users
- GET /users/{id}
- DELETE /users/{id}

### Tasks 
- GET /tasks
- GET /users/{id}/tasks
- GET /users/{id}/tasks/{id}
- POST /users/{id}/tasks
- DELETE /tasks/{id}
