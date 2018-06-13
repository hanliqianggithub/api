FROM daocloud.io/brave8/maven-jdk8
RUN mkdir -p /opt/app
WORKDIR /opt/app
COPY ./run_jar.sh ./app-assembly.jar ./
ENTRYPOINT ["./run_jar.sh"]