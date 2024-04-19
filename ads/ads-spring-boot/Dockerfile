# Stage 1: Build the application
FROM maven:3.8-openjdk-17 as builder
WORKDIR /app
# Copy the project files into the image
COPY pom.xml .
COPY src ./src
# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Setup the runtime container
FROM openjdk:17
WORKDIR /app
# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

