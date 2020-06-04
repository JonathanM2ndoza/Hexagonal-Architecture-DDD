# Products Microservice

Example of Orders Microservice applying Hexagonal Architecture pattern, Domain Driven Design (DDD) and SOLID principles.

This example was implemented with Spring Boot, PostgreSQL. The microservices and the DB are deployed locally.

### Start a PostgreSQL Server 

1. Start a PostgreSQL server instance with Docker Hub

```shell
jmendoza@jmendoza-ThinkPad-T420:~$ docker run -d --name postgres -e POSTGRES_PASSWORD=root.jmtizure.k201 postgres
```

![Screenshot](prtsc/Order-5.png)

2. Create a new Customer database

![Screenshot](prtsc/Order-6.png)

*Note: I am using pgAdmin 4 (Container), is a GUI client for PostgreSQL*

3. Execute the following scripts in the public schema.

![Screenshot](prtsc/Order-4.png)

## Configure your application.properties

Find the IP address of your postgres container

```shell
jmendoza@jmendoza-ThinkPad-T420:~$ docker inspect postgres
```

![Screenshot](prtsc/Order-8.png)

![Screenshot](prtsc/Order-7.png)

## Create Order

**Postman**

![Screenshot](prtsc/Order-1.png)

**PostgreSQL**

![Screenshot](prtsc/Order-2.png)

![Screenshot](prtsc/Order-3.png)

## Get Orders

**Postman**

![Screenshot](prtsc/Product-4.png)

