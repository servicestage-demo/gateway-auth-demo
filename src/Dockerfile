FROM openjdk:17.0.2

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone

WORKDIR /home/apps/
ADD target/cse_gateway_auth_demo-0.0.1.jar .
ADD start.sh .

ENTRYPOINT ["sh", "/home/apps/start.sh"]