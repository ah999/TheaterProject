#base image
FROM openjdk:8
COPY . /src/java
WORKDIR /src/java
RUN ["javac","ClientThreadPool.java"]
RUN ["javac","ServerThreadPool.java"]
ENTRYPOINT ["java","THEATERPROJECT-MASTER"]
