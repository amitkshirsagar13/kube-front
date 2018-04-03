# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jre-alpine
# copy application WAR (with libraries inside)
COPY target/kube-front-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8989
# specify default command
CMD ["/usr/bin/java", "-jar", "/app.jar"]
