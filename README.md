
# Run API

## Prerequisites
You need
 - java 17
 - maven 3.3.6 or +

## Launch

```mvn spring-boot:run```

## Test

```mvn clean test```

## Build

```mvn clean package```

## Start a redis with docker or postman

> If you are using docker, replace 'podman' command with 'docker'

```podman run -v redis/redis.conf:/usr/local/etc/redis --name demo-cache-redis redis:6.2.6```

# Test API
## Create Pizzas
```
curl -d 'reine' -H 'Content-Type: application/json' http://localhost:8080/api/pizzas
curl -d 'calzone' -H 'Content-Type: application/json' http://localhost:8080/api/pizzas
```

## Get all pizzas
```curl http://localhost:8080/api/pizzas```

## Get pizza by id
```curl http://localhost:8080/api/pizzas/4b523a73-2556-41be-a6cb-38d2e140d1e0```

## Update a Pizza
```curl -d 'margherita' -H 'Content-Type: application/json' -X PUT http://localhost:8080/api/pizzas/4b523a73-2556-41be-a6cb-38d2e140d1e0```

## Delete a Pizza
```curl -X DELETE http://localhost:8080/api/pizzas/4b523a73-2556-41be-a6cb-38d2e140d1e0```