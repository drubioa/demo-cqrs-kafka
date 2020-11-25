FROM maven:3.6.3-openjdk-8-slim AS build
COPY demo-command/src /usr/src/demo-command/src
COPY demo-command/pom.xml /usr/src/demo-command
COPY demo-query/src /usr/src/demo-query/src
COPY demo-query/pom.xml /usr/src/demo-query
RUN mvn -f /usr/src/demo-command/pom.xml clean package
RUN mvn -f /usr/src/demo-query/pom.xml clean package

FROM openjdk:8-alpine AS demo-command
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /usr/src/demo-command/target/demo-0.0.1-SNAPSHOT.jar /usr/demo-command/demo-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/app/demo-0.0.1-SNAPSHOT.jar"]

FROM openjdk:8-alpine AS demo-query
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /usr/src/demo-query/target/demo-0.0.1-SNAPSHOT.jar /usr/demo-query/demo-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/usr/app/demo-0.0.1-SNAPSHOT.jar"]