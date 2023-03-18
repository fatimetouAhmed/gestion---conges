FROM eclipse-temurin:11-jdk-alpine as build
WORKDIR /workspace/app
COPY . .

RUN ./mvnw clean install -DskipTests


RUN cp target/*.jar api.jar


ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","api.jar"]

EXPOSE 8089
