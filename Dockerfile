from openjdk:alpine

WORKDIR /app

COPY ./build/libs/simple-db-rest-0.0.1.jar /app/simple-db.jar


ENTRYPOINT ["java","-jar","simple-db.jar"]
