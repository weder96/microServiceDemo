FROM openjdk:11

# install curl for a health check
RUN apt-get update && apt-get install -y curl
COPY target/notification-0.0.1-SNAPSHOT.jar notification.jar
ENTRYPOINT ["java", "-jar", "notification.jar"]