FROM daocloud.io/brave8/maven-jdk8
ADD akka-http-microservice-assembly-1.0.0.jar /tmp/app.jar
VOLUME /tmp
EXPOSE 9000
ENTRYPOINT ["java","-jar","/tmp/app.jar"]