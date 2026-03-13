FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY build/libs/cloud-native-msa-user-1.jar cloud-native-msa-user.jar

VOLUME /tmp

ENTRYPOINT ["java","-jar","cloud-native-msa-user.jar"]