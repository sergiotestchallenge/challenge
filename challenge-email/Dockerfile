FROM openjdk:11-jre-slim
RUN mkdir -p /target/
COPY target ./target
RUN ls /target
COPY target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
 