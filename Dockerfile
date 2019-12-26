FROM maven:3.6.0-jdk-8-alpine AS builder
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package


FROM openjdk:8-jre-alpine
#RUN apt-get update
COPY --from=builder usr/src/app/target/*.jar app.jar
#COPY --from=builder /biuld/libs/*.jar app.jar
# ARG JAR_FILE
# ADD target/${JAR_FILE} app.jar 
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar
