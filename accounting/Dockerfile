FROM openjdk:11

# install curl for a health check
RUN apt-get update && apt-get install -y curl
COPY target/accounting-0.0.1-SNAPSHOT.jar accounting.jar
ENTRYPOINT ["java", "-jar", "accounting.jar"]