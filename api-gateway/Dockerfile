FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/*.jar gateway.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "gateway.jar"]