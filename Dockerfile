FROM amazoncorretto:21-alpine

EXPOSE 8080

#COPY build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]


