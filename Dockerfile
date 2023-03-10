# syntax=docker/dockerfile:experimental
FROM thinhda/spring-grpc-base as base

WORKDIR /app
ADD core /app
RUN --mount=type=cache,id=cache-maven,target=/root/.m2 mvn clean install

FROM openjdk:11.0.2-slim
WORKDIR /app

EXPOSE 8881
EXPOSE 8888

COPY --from=base /app/target/*.jar .
CMD java -jar app.jar
