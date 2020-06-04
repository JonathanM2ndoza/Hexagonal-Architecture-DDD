# Products Microservice

Example of Orders Microservice applying Hexagonal Architecture pattern, Domain Driven Design (DDD) and SOLID principles.

This example was implemented with Spring Boot, PostgreSQL. The microservices and the DB are deployed locally.

### Start a PostgreSQL Server 

1. Start a PostgreSQL server instance with Docker Hub

jmendoza@jmendoza-ThinkPad-T420:~$ docker run -d --name postgres -e POSTGRES_PASSWORD=root.jmtizure.k201 postgres

2. Create a new Customer database

3. Execute the following scripts in the public schema.

![Screenshot](prtsc/Order-4.png)
 

## Configure your application.properties

![Screenshot](prtsc/Product-2.png)

## Create Products

**Postman**

![Screenshot](prtsc/Product-3.png)

![Screenshot](prtsc/Product-3.1.png)


**MongoDB Atlas**

![Screenshot](prtsc/Product-3.2.png)

## Get Products

**Postman**

![Screenshot](prtsc/Product-4.png)

