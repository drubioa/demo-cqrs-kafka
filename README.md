<p align="left">
  <a href="https://github.com/actions/setup-java"><img alt="GitHub Actions status" src="https://github.com/actions/setup-java/workflows/Main%20workflow/badge.svg"></a>
</p>


# Prueba de concepto de CRQR con Apache Kafka

Prueba de concepto de *CQRS* con *Event sourcing*. En esta prueba se dispondrán de dos microservicios desarrollados en mediante Spring Boot (Uno para la parte Command y otro para la parte Query). Ambos microservicios dispondrán de una base de datos en *h2* una orientada a escritura y otra a la lectura.

Para sincronizar ambas bases de datos dispondremos de un topic de kafka en el que se realizará la comunicación de eventos entre command y query.

 

## Getting Started

La idea principal de esta prueba es realizarla en una máquina local. Para ellos se desplegarán los siguientes contenedores:


## Requisitos

Disponer de docker y docker-compose en la máquina en la que se va a realizar la prueba.

## Installation

Para la realización de esta prueba disponemos del fichero `docker-compose.yml` en el cual se construye una imagen para un servidor kafka, un zookeeper, un microservicio query y un microservicio command.

Para construir y desplegar en docker las imágenes hay que realizar el siguiente comando:

```bash
docker-compose up
```

