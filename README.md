# Challenge - Sucursal CRUD

[Enunciado](https://github.com/cassa10/challenge-api-fravega/blob/main/doc/software-engineer_challenge-1.pdf)

# Deploy Enviroment

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://challenge-api-fravega.herokuapp.com/)

# Pre-Requirements

  - java 8
  - maven
  - postgresql
  - Docker (optional)
  - Bash (docker)

# Install and run API with Docker (Recommended)

1. Clone repository
2. CD to repository cloned
3. CD to backend
4. Execute command:
  >mvn clean install
5. CD back and give execution permission to runDocker.sh
  >chmod +x runDocker.sh
6. Execute runDocker.sh script 

## High-level explanation of runDocker.sh

- Requires fat jar of app (Generated at 4th step in last section) for building image of app

- Build docker image of app with Dockerfile

- Execute docker compose and start containers (database and app) with configuration at docker-compose.yml

# Install and run API (without Docker)

1. Clone repository
2. CD to repository cloned
3. Config. Properties (2 options)

    A. Set up all enviroments variables at list.env (Recommended) 
    
    B. Replace all properties of application.properties with values of list.env

4. Execute command "mvn install"
5. Create database with name "challenge-api-db"
6. Execute command "mvn spring-boot:run" for start API


# API Doc

## Swagger Doc

Documentation of all available endpoints and Model DTO's

- Run API or visit Heroku deploy enviroment

- Visit endpoints "/" or "/swagger-ui.html"

Example:
  >https://challenge-api-fravega.herokuapp.com/

  >https://challenge-api-fravega.herokuapp.com/swagger-ui.html

## Health Checks

Health checks of:

 - Server Network
 - Database
 - Disk space

Use endpoint /actuator/health

Example: 
  >https://challenge-api-fravega.herokuapp.com/actuator/health

## Model Endpoints

*<b>(Suggest) Go to Swagger Doc for watching request model data and data responses </b>*

### Nodo

#### /nodo

- GET

  Get all nodo objects (sucursal and puntoDeRetiro)

#### /nodo/cercano?latitude=<*value*>&longitude=<*value*>

- GET

    Gets the nearest node of requested location at query parameters with latitude and longitude

### Sucursal


####  /sucursal

- GET
    
    Get all sucursal objects (no pagination)

- POST 

    Creates new sucursal

#### /sucursal/<id\>

- GET

    Gets sucursal with requested id

- DELETE

    Deletes sucursal with requested id (logic deleted not contemplated)

- PUT

    Updates sucursal with requested id and data provided

### PuntoDeRetiro

####  /puntoDeRetiro

- GET
    
    Get all puntoDeRetiro objects (no pagination)

- POST

    Creates new puntoDeRetiro

####  /puntoDeRetiro/<id\>

- GET

    Gets puntoDeRetiro with requested id

- DELETE

    Deletes puntoDeRetiro with requested id (logic deleted not contemplated)

- PUT

    Updates puntoDeRetiro with requested id and data provided



