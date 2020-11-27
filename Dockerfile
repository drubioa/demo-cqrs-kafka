FROM maven:3.6.3-openjdk-8-slim AS build
COPY demo-command/src /usr/src/demo-cqrs/demo-command/src
COPY demo-command/pom.xml /usr/src/demo-cqrs/demo-command
COPY demo-query/src /usr/src/demo-cqrs/demo-query/src
COPY demo-query/pom.xml /usr/src/demo-cqrs/demo-query
COPY pom.xml /usr/src/demo-cqrs
RUN mvn -f /usr/src/demo-cqrs/pom.xml clean package

FROM openjdk:8-alpine AS demo-command
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /usr/src/demo-cqrs/demo-command/target/demo-command-0.0.1-SNAPSHOT.jar /usr/app/demo-command-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/app/demo-command-0.0.1-SNAPSHOT.jar"]

FROM openjdk:8-alpine AS demo-query
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /usr/src/demo-cqrs/demo-query/target/demo-query-0.0.1-SNAPSHOT.jar /usr/app/demo-query-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/usr/app/demo-query-0.0.1-SNAPSHOT.jar"]