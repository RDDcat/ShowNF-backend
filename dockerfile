FROM openjdk:8-jdk
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
ENTRYPOINT ["java", "-jar", "/app.jar",
"-Dspring-boot.run.arguments=--datasource.username=${DATASOURCE_USERNAME},
--datasource.password=${DATASOURCE_PASSWORD}"]