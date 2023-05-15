FROM eclipse-temurin:17-jdk-alpine

COPY ./build/libs/docker-users-0.0.1-SNAPSHOT.jar users.jar

ENTRYPOINT ["java", "-jar", "users.jar"]