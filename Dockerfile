FROM maven:3.6.3-openjdk-15 AS task
WORKDIR /usr/src/app/
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn clean install

FROM openjdk:15
WORKDIR /usr/src/app/
COPY --from=task /usr/src/app/target/gulag-0.0.1-SNAPSHOT.jar ROOT.jar
EXPOSE 8080
ENV DB_HOST=postgres
CMD java -Ddb.host=${DB_HOST} -jar ROOT.jar
