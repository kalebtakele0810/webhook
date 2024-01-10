FROM openjdk:17-jdk-slim

LABEL maintainer="Kaleb.Takele"

EXPOSE 8080

VOLUME /tmp

ADD target/webhook-*.jar webhook.jar

ENV TZ=Africa/Addis_Ababa

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

CMD ["java", "-jar", "/webhook.jar"]