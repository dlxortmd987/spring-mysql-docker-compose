FROM openjdk:17-oracle
WORKDIR /usr/src/app
COPY ./build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]