#指定基础镜像信息
FROM java:8
#维护者信息
MAINTAINER yurwisher <yurwisher@gmail.com>
#指定了临时文件目录为/tmp
#VOLUME /tmp
#添加的jar包文件名
COPY dota2-starter-1.0.0.jar app.jar
# 设置docker容器时间与宿主机时间同步 #执行 touch
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo 'Asia/Shanghai' >/etc/timezone \
    && bash -c 'touch /app.jar'
#申明容器打开的端口
EXPOSE 8111
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar" ]
