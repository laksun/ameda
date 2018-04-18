FROM openjdk:8-jdk
MAINTAINER <ylaksun@yahoo.com>

#COPY C:\Users\admin\.m2\repository\com\github\tutorial\Spring-Full-Security\1.0-SNAPSHOT\Spring-Full-Security-1.0-SNAPSHOT.war  /app/Spring-Full-Security-1.0-SNAPSHOT.war
COPY  C:\Users\yaksun\.m2\repository\com\github\tutorial\Spring-Full-Security\1.0-SNAPSHOT\Spring-Full-Security-1.0-SNAPSHOT.war  /app/Spring-Full-Security-1.0-SNAPSHOT.war 

VOLUME /tmp 

EXPOSE 8080 8443


CMD ["java","-jar","/app/Spring-Full-Security-1.0-SNAPSHOT.war"]

