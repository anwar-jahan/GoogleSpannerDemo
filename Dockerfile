FROM openjdk:8
COPY build/libs/GoogleSpannerDemo.jar /app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java", "-jar", "/app.jar"]