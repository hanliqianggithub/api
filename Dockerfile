FROM daocloud.io/brave8/maven-jdk8
ADD app-assembly /tmp/app.jar
VOLUME /tmp
EXPOSE 9000
ENTRYPOINT ["java","-jar","/tmp/app.jar"]