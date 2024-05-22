FROM amazoncorretto:17alpine-jdk

COPY target/mails-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ['java','-jar','/app.jar']