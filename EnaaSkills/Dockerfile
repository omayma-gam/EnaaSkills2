FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/*.jar enna.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "enna.jar"]