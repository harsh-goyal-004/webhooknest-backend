# Stage 1: Build jar inside container
FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app

# Copy everything and build jar
COPY . .

RUN ./mvnw clean package -DskipTests

# Stage 2: Run the jar
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
