#通过该Dockerfile文件制作出来的镜像为精简版镜像，不包含jre,体积小
#获取基础镜像sailing.com/alpine-base:1.0.0
FROM openjdk:8-jre-alpine
#指定维护者信息
MAINTAINER ryr
VOLUME /tmp
ADD target/spring-boot-docker-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
#该端口为自定义端口,与配置文件中的server.port值一致
EXPOSE 8080
#指定执行启动spring boot小项目 ENTRYPOINT 为容器启动后执行的命令 jar 运行命令 java -Djava.security.egd -jar /app.jar, -Djava.security.egd表示自启动的意思
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]