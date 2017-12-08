#Compile the code

mvn install

To run the application:
	mvn tomcat7:run

Test from browser	
http://localhost:9000/Speech

To analyse the project with sonarqube

Install sonarqube docker image

docker pull sonarqube

docker run -d --name sonarqube -p 9000:9000 -p 9002:9002 sonarqube

In your project server

mvn sonar:sonar -Dsonar.host.url=http://10.10.1.246:9000 -Dsonar.login=b95ebc9f9110ab0731d2d1504732a25157b78a4c

1. 	A new page, ReadFile.jsp

2. 

Reference:
https://www.safaribooksonline.com/library/view/pro-mongodbtm-development/9781484215982/9781484215999_Ch10.xhtml