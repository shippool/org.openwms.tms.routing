FROM azul/zulu-openjdk-alpine:11-jre
VOLUME /tmp
ARG JAVA_OPTS="-noverify -Xmx300m -Xss512k"
ADD target/openwms-tms-routing.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar
