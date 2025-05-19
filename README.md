# WebhookNest Backend

This is the backend service for **WebhookNest**, a RequestBin-like tool to capture, store, and inspect HTTP POST requests sent to unique webhook URLs. Built using Spring Boot and MongoDB.

---

##  Tech Stack

-  Java 17+
-  Spring Boot
- Spring Web (REST APIs)
-  Spring Data MongoDB
-  UUID for unique bin generation
-  MongoDB

---

##  Features

-  Create a unique webhook bin URL
-  Accept POST requests at those URLs
-  Store request headers and body in MongoDB
-  Retrieve all requests tied to a specific bin
-  Timestamp every request
-  Enable CORS for frontend communication
- Deployed on Railway

---

##  Getting Started

###  Clone the repository

```bash
git clone https://github.com/harsh-goyal-004/webhooknest-backend.git

cd webhooknest-backend
```

###  Configure MongoDB
Make sure MongoDB is running locally:

```bash
mongodb://localhost:27017
```

### Update application.properties if needed:
```
spring.data.mongodb.uri=mongodb://localhost:27017/webhooknest
spring.data.mongodb.database=webhooknest
server.port=8080
```
---
## Run the application

### Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

### Or with installed Maven:

```bash
mvn spring-boot:run
```
Backend will run at:
http://localhost:8080

## API Endpoints

| Method | Endpoint       | Description                       |
|--------|----------------|-----------------------------------|
| GET    | `/api/bins`    | Create a new webhook bin          |
| POST   | `/api/{binId}` | Accept a POST request for the bin |
| GET    | `/api/{binId}` | Get captured requests for a bin   |

---

## Example Payload

```bash
curl -X POST http://localhost:8080/api/bin/abc123 \
-H "Content-Type: application/json" \
-d '{"name": "WebhookNest"}'
```
---

## Author
Built with 💻 by Harsh Goyal