FROM openjdk:8-jdk
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar", "-Dspring-boot.run.arguments=--spring.datasource.url=${SPRING_DATASOURCE_URL}, --spring.datasource.username=${SPRING_DATASOURCE_USERNAME}, --spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}, --cloud.aws.credentials.accessKey=${AWS_S3_ACCESSKEY}, --cloud.aws.credentials.secretKey=${AWS_S3_SECRETKEY}"]