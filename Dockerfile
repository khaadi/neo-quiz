FROM openjdk:17
MAINTAINER Khaadi Bolotbekov
COPY target/neo_quiz-0.1.jar neo_quiz.jar
ENTRYPOINT ["java","-jar","/neo_quiz.jar"]