FROM java:8
VOLUME /tmp
ADD boot-demo-0.0.1-SNAPSHOT.jar app.jar
ADD run.sh run.sh
RUN chmod 555 run.sh
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
