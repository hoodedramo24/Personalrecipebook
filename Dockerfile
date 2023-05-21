FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmpdocker build -t
EXPOSE 8080
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]