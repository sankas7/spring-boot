FROM openjdk:17-jdk-alpine
LABEL author="pramit" 
COPY target/spring3-learn-demo-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/spring3-learn-demo-0.0.1-SNAPSHOT.jar"]