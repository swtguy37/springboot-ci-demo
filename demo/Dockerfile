FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/demo-0.0.1.jar demo.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "demo.jar"]

