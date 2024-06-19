FROM openjdk:20
ARG JAR_FILE=out/artifacts/Pancakes_jar/Pancakes-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} Pancakes-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","./Pancakes-1.0-SNAPSHOT.jar"]