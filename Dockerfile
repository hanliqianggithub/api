FROM daocloud.io/brave8/maven-jdk8
RUN mkdir -p /opt/app
WORKDIR /opt/app
COPY ./run_jar.sh ./akka-http-microservice-assembly-1.0.0.jar ./
ENTRYPOINT ["./run_jar.sh"]