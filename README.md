
# Demo for CQRS with Spring Boot, Apache Kafka and Mongo
![Java CI with Maven](https://github.com/drubioa/demo-cqrs-kafka/workflows/Java%20CI%20with%20Maven/badge.svg)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

The main propose of this project is test CQRS with Event Sourcing.  

![diagram](./resources/diagram.jpg)

# Starting 🚀

## Requirements 📋
To install and run this project you may be installes next requirements:
- jdk8
- maven
- docker and docker-compose

## Installation 🔧
To generate jar files run the following command in root path:

```bash
mvn clean package
```
Wait a minute, when you see all containers running yo can launch the Spring Boot microservices:

### Microservice for command
Run the following command:

```bash
java -jar demo-command/target/demo-command-0.0.1-SNAPSHOT.jar.original
```

### Microservice for query
In other terminal run the following command:

```bash
java -jar demo-query/target/demo-query-0.0.1-SNAPSHOT.jar.original
```


Next step is download images of *Apache Kafka, Zoookeper and Mongo*. 

```bash
docker-compose up -d
```

# Running project ⚙️
Once all microservice started you can test this serive using the command endpoint and service endpoint. I show you one example for POST and GET http rest requests with curl command:

```
curl --location --request POST 'localhost:8081/phone' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "iphone11",
    "model": "11",
    "color": "red",
    "price": 800.99
}'
```

```
curl --location --request GET 'localhost:8082/phone/iphone08'
```



