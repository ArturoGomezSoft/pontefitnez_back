FROM eclipse-temurin:17-jdk-focal
EXPOSE 8080
ADD target/pontefitnez_back-1.0.0.jar pontefitnez_back-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/pontefitnez_back-1.0.0.jar"]