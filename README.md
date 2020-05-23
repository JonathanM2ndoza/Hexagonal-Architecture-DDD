# Hexagonal-Architecture-DDD

Example of how to use Domain Driven Design (DDD) and Hexagonal Architecture with Microservices. 

This example is made with Spring Boot and MongoDB.

## Domain Driven Design (DDD)

Domain-Driven Design is an approach to software development that centers the development on programming a domain model that has a rich understanding of the processes and rules of a domain.

Bounded Context is a central pattern in Domain-Driven Design. It is the focus of DDD's strategic design section which is all about dealing with large models and teams. DDD deals with large models by dividing them into different Bounded Contexts and being explicit about their interrelationships.

![Screenshot](prtsc/Hexa-Arch-DDD-1.png)

Reference:
- https://martinfowler.com/tags/domain%20driven%20design.html

## Hexagonal Architecture

The hexagonal architecture, or ports and adapters architecture, is an architectural pattern used in software design. It aims at creating loosely coupled application components that can be easily connected to their software environment by means of ports and adapters. This makes components exchangeable at any level and facilitates test automation.

The business logic interacts with other components through ports and adapters. This way, we can change the underlying technologies without having to modify the application core.

### The hexagonal architecture is based on three principles and techniques:

- Explicitly separate Application, Domain, and Infrastructure
- Dependencies are going from Application and Infrastructure to the Domain
- We isolate the boundaries by using Ports and Adapters

![Screenshot](prtsc/Hexa-Arch-DDD-2.png)



Reference:
- https://en.wikipedia.org/wiki/Hexagonal_architecture_(software)
- https://dzone.com/articles/hexagonal-architecture-in-java-2
- https://blog.octo.com/en/hexagonal-architecture-three-principles-and-an-implementation-example/#principles


