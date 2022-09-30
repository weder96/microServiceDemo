FROM openjdk:11

# install curl for a health check
RUN apt-get update && apt-get install -y curl
COPY target/kitchen-0.0.1-SNAPSHOT.jar kitchen.jar
ENTRYPOINT ["java", "-jar", "kitchen.jar"]