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


To install docker for mongo db
1. get the docker image for mongodb

docker pull mongo

2. create the container from the docker image
docker run --name speech-mongo  -p 27017:27017   -v /var/lib/docker/development/mongodb/data/:/data/db -d mongo

3. access the mongo inside docker

docker exec -it speech-mongo mongo

4. Some mongo-db commands:
use local
show dbs
db.stats()
db.runCommand({listDatabases:1})
db.createCollection("pdfFiles")
db.copydatabase('dborigin','dbcopy')
db.dropDatabase()
doc1 = {"_id": ObjectId("sfsdf"), "catalogId" : "catalog1", "journal" : 'Oracle Magazine', "publisher" : 'Oracle Publishing', "edition" : 'November December 2013',"title" : 'Engineering as a Service',"author" : 'wefwe wer wer'};

db.tripsFiles.insert(doc1)
db.collection.save(doc1)

5. Add Spring exception handling mechanism into the application

Reference:
https://www.safaribooksonline.com/library/view/pro-mongodbtm-development/9781484215982/9781484215999_Ch10.xhtml

2. https://www.journaldev.com/2651/spring-mvc-exception-handling-controlleradvice-exceptionhandler-handlerexceptionresolver