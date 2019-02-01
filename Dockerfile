FROM java:8
EXPOSE 8080
ADD /target/FairGrounds-1.0-SNAPSHOT.jar fairgrounds.jar
RUN bash -c 'touch /fairgrounds.jar'
ENTRYPOINT ["java","-jar","fairgrounds.jar"]
