# Speaking Clock Microservice

This microservice converts 24-hour time format (HH:mm) into words.

## Build

```bash
mvn clean install
```

## Run

```bash
mvn spring-boot:run
```

## API Endpoint

- `GET /api/time/convert?inputTime=08:34`

## Swagger

Access at: `http://localhost:8080/swagger-ui/`
