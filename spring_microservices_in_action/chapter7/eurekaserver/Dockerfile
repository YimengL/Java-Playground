# Start with a base image containing Java runtime
FROM openjdk:11-slim

# Add Maintainer Info
LABEL maintainer="Yimeng Li<yimengcsu@gmail.com>"

# The application's jar file
# Defines the JAR_FILE variable set by dockerfile-maven-plugin
ARG JAR_FILE

# Add the application's jar to the container
# Copies the JAR file to the filesystem of the image named app.jar
COPY ${JAR_FILE} app.jar

# Execute the application
# Targets the licensing service application in the image when continaer is created
ENTRYPOINT ["java", "-jar", "/app.jar"]