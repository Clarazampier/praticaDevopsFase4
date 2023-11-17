# STAGE Build - servidor 1
FROM maven:3.8.3-openjdk-17 AS maquinabuild

COPY . .

RUN mvn clean package -DskipTests

# STAGE Packege / Deploy - servidor 2

FROM openjdk:17-jdk-slim

COPY --from=maquinabuild /target/pratica_API-0.0.1-SNAPSHOT.jar teste.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "teste.jar"]
