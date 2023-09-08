FROM openjdk:8-jdk
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar", "-Dspring-boot.run.arguments=--datasource.url=${SPRING_DATASOURCE_URL}, --datasource.username=${SPRING_DATASOURCE_USERNAME}, --datasource.password=${SPRING_DATASOURCE_PASSWORD}, --aws.s3.accesskey=${AWS_S3_ACCESSKEY}, --aws.s3.secretkey=${AWS_S3_SECRETKEY}"]