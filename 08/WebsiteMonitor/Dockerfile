# Use official Java image
FROM openjdk:17-jdk-slim

# Set work directory
WORKDIR /app

# Copy the JAR into the container
COPY target/website-monitor-1.0-SNAPSHOT.jar website-monitor.jar

# Run the application
ENTRYPOINT ["java", "-jar", "website-monitor.jar"]