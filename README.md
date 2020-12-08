# Challenge - Sucursal CRUD

[Enunciado](https://github.com/cassa10/challenge-api-fravega/blob/main/doc/software-engineer_challenge-1.pdf)

# Pre-Requirements

  - java 8
  - maven
  - postgresql
  - Docker (optional)

# Install and run API with Docker (Recommended)

1. Clone repository
2. CD to repository cloned
3. 

# Install and run API (without Docker)

1. Clone repository
2. CD to repository cloned
3. Config. Properties

    A. Set up all enviroments variables at list.env (Recommended) 
    
    B. Change all properties of application.properties (In case of skip 3.A)

4. Execute command "mvn install"
5. Create database with name "challenge-api-db"
6. Execute command "mvn spring-boot:run" for start API


# API Doc

## Swagger Doc

Documentation of all available endpoints and Model DTO's

- Run API

- Go to endpoints "/" or "/swagger-ui.html"

Example:
  >localhost:8080/

  >localhost:8080/swagger-ui.html

## Health Checks

Health checks of:

 - Server Network
 - Database
 - Disk space

Use endpoint /actuator/health

Example: 
  >localhost:8080/actuator/health

## Model Endpoints

*<b>(Suggest) Go to Swagger Doc </b>*

### Nodo


### Sucursal


### PuntoDeRetiro




