FROM adoptopenjdk/openjdk11:latest

VOLUME /temp

ADD target/JavaciRestDockerInClass-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]