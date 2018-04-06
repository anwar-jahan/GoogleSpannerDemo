FROM openjdk:8
EXPOSE 8080

COPY . /code

RUN cd /code \
    && ./gradlew -x test clean build \
    && mkdir /app \
    && mv /code/build/libs/*.jar /app/app.jar \
    && mv doorapi*.json /app \
    && mv /code/Dockerfile /app \
    && rm -rf /code

WORKDIR /app

CMD java -jar app.jar
