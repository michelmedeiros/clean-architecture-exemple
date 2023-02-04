FROM adoptopenjdk/openjdk11:latest as builder
RUN jlink \
    --module-path "$JAVA_HOME/jmods" \
    --add-modules java.compiler,java.sql,java.naming,java.management,java.instrument,java.rmi,java.desktop,jdk.internal.vm.compiler.management,jdk.crypto.cryptoki \
    --verbose \
    --strip-debug \
    --compress 2 \
    --no-header-files \
    --no-man-pages \
    --output /opt/jre-minimal

# img
FROM adoptopenjdk/openjdk11:latest
ENV JAVA_EXECUTION_MODE standard
ENV APP_NAME example

COPY --from=builder /opt/jre-minimal $JAVA_HOME

COPY ./app/target/app.jar $SPRINGBOOT_JAR
COPY ./app/src/main/resources/application*.yml $ENV_HOME/
ENTRYPOINT ["java", "-jar", "/app.jar"]