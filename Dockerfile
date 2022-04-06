FROM open-jdk:8
ADD build/lib/cloudifiers-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "app.jar"]