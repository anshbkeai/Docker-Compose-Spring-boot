FROM eclipse-temurin:24-jdk-slim 

WORKDIR /app

COPY target/*.jar app.jar


CMD ["java" , "-jar" ,"app.jar"]