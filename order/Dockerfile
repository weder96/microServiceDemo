FROM openjdk:11

# install curl for a health check
RUN apt-get update && apt-get install -y curl
COPY target/order-0.0.1-SNAPSHOT.jar order.jar
ENTRYPOINT ["java", "-jar", "order.jar"]