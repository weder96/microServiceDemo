FROM openjdk:11

# install curl for a health check
RUN apt-get update && apt-get install -y curl
COPY target/restaurant-0.0.1-SNAPSHOT.jar restaurant.jar
ENTRYPOINT ["java", "-jar", "restaurant.jar"]