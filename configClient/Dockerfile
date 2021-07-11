FROM adoptopenjdk/openjdk11
VOLUME /tmp
COPY ./build/libs/configClient-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/app.jar"]
