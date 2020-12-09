# official image, using alpine because is smallest unix image
FROM openjdk:8-jdk-alpine

EXPOSE 8080

ARG JAR_FILE=./backend/target/challenge-api-fravega-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} /app.jar

ENTRYPOINT ["java","-jar","/app.jar","-DskipTests=true"]