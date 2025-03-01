# Build stage
FROM eclipse-temurin:21-jdk as builder
WORKDIR /app
COPY . .
RUN chmod +x mvnw  # Fix permissions upfront
RUN ./mvnw -B -DskipTests clean install

# Run stage
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]