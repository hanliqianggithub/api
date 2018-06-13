FROM daocloud.io/brave8/maven-jdk8
ADD app-assembly.jar /tmp/app-assembly.jar
VOLUME /tmp
EXPOSE 9000
ENTRYPOINT ["java","-jar","/tmp/app-assembly.jar"]