# Orders Microservice

Example of Orders Microservice applying Hexagonal Architecture pattern, Domain Driven Design (DDD) and SOLID principles.

This example was implemented with Spring Boot, PostgreSQL. The microservices and the DB are deployed locally.

### Start a PostgreSQL Server 

1. Start a PostgreSQL server instance with Docker Hub

```shell
jmendoza@jmendoza-ThinkPad-T420:~$ docker run -d --name postgres -e POSTGRES_PASSWORD=root.jmtizure.k201 postgres
```

2. Start pgAdmin 4 (Container), is a GUI client for PostgreSQL
```shell
jmendoza@jmendoza-ThinkPad-T420:~$ docker run --name pgadmin4 -p 5050:80 -e "PGADMIN_DEFAULT_EMAIL=jmtizure@gmail.com" -e "PGADMIN_DEFAULT_PASSWORD=123456789" -d  dpage/pgadmin4
```

![Screenshot](prtsc/Order-9.png)

![Screenshot](prtsc/Order-5.png)

3. Create a new Customer database

![Screenshot](prtsc/Order-6.png)

4. Execute the following scripts in the public schema.

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

