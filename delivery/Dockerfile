FROM openjdk:11

# install curl for a health check
RUN apt-get update && apt-get install -y curl
COPY target/delivery-0.0.1-SNAPSHOT.jar delivery.jar
ENTRYPOINT ["java", "-jar", "delivery.jar"]