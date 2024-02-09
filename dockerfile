FROM eclipse-temurin:17-jdk-focal
ADD target/SpringBootApi-0.0.1-SNAPSHOT.jar SpringBootApi-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "SpringBootApi-0.0.1-SNAPSHOT.jar"]