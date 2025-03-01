# Build stage
FROM eclipse-temurin:21-jdk as builder

WORKDIR /app
#Copies ALL files (including mvnw)
COPY . .

# Fix permissions for mvnw inside the container
RUN chmod +x mvnw

# Build the app (no manual permission fixes needed)
RUN ./mvnw -B -DskipTests clean install

# Runtime stage
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]