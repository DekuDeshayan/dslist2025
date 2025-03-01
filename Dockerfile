# Use Java 21 (Temurin JDK)
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy all project files into the container
COPY . .

# Build the application using Maven
RUN mvn -B -DskipTests clean package

# Run the Spring Boot application
CMD ["java", "-jar", "target/*.jar"]
