FROM maven:3.6.3-openjdk-11 AS builder
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml package

FROM arm32v7/adoptopenjdk:latest
RUN mkdir /opt/app
COPY --from=builder /usr/src/app/target/hello-0.0.1-SNAPSHOT.jar /opt/app/app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/opt/app/app.jar" ]
