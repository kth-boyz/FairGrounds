FROM java:8
EXPOSE 8080
ADD /target/FairGrounds-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","app.jar"]
