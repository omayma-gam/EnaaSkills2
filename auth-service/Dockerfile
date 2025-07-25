FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/*.jar auth.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "auth.jar"]