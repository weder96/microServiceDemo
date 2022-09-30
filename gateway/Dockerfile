FROM openjdk:11

# install curl for a health check
RUN apt-get update && apt-get install -y curl
COPY target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
ENTRYPOINT ["java", "-jar", "gateway.jar"]