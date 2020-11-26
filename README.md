<p align="left">
  <a href="https://github.com/drubioa/demo-cqrs-kafka/actions"><img alt="GitHub Actions status" src="https://github.com/actions/setup-java/workflows/Main%20workflow/badge.svg"></a>
</p>


# Prueba de concepto de CRQR con Apache Kafka

Prueba de concepto de *CQRS* con *Event sourcing*. En esta prueba se dispondrán de dos microservicios desarrollados en mediante Spring Boot (Uno para la parte Command y otro para la parte Query). Ambos microservicios dispondrán de una base de datos en *h2* una orientada a escritura y otra a la lectura.

Para sincronizar ambas bases de datos dispondremos de un topic de kafka en el que se realizará la comunicación de eventos entre command y query.

## Getting Started

La idea principal de esta prueba es realizarla en una máquina local. Para ellos se desplegarán los siguientes contenedores:

Para esta prueba de concepto dispondremos de dos microservicios.

### Microservicio Command
Este servicio dispone de un *endpoint* para crear un nuevo teléfono. Recibe un json con un nuevo teléfono. Lo introducirá en la base de datos de command, y seguidamente creará un evento en un *topic* de *Kafka* el cual actualizará la base de datos de query.

Para probar este microservicio:

```
curl --location --request POST 'localhost:8081/phone' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "iphone12",
    "model": "11",
    "color": "red",
    "price": 800.99
}'
```

### Microsericio Query
Este microservicio dispone de un endpoint para consultar teléfonos por nombre.
Además dispone de un *Listener* que está escuchando el topic de kafka y que detecta eventos de creacion de nuevos teléfonos y actualiza la base de datos de query.

```
curl --location --request GET 'localhost:8083/phone/iphone12'
```

Esta llamada puede devolver 404 en caso de que no exista el teléfono, o bien 200 y el json con información del dispositivo.

![Screenshot](resources/diagram.png)

## Requisitos

Disponer de docker y docker-compose en la máquina en la que se va a realizar la prueba.

## Instalación

Para la realización de esta prueba disponemos del fichero `docker-compose.yml` en el cual se construye una imagen para un servidor kafka, un zookeeper, un microservicio query y un microservicio command.

Para construir y desplegar en docker las imágenes hay que realizar el siguiente comando:

```bash
docker-compose up
```

