FROM openjdk:11

# install curl for a health check
RUN apt-get update && apt-get install -y curl
COPY target/eurekaServer-0.0.1-SNAPSHOT.jar eurekaServer.jar
ENTRYPOINT ["java", "-jar", "eurekaServer.jar"]