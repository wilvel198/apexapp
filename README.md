# apexapp
WebAPI Developer

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction.

(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

To verify that the service is up and running access the following URL

-----------------------------------------------------------------------------
Application was created by generating a project with Spring Intializer site

https://start.spring.io/

Environment: Windows 11
JVM: Microsoft Build of OpenJDK
Source: https://learn.microsoft.com/en-us/java/openjdk/download

http://localhost:8080/apexsolutions/status

you should see the following response

{"responseInformation":"The Service is Up"}

A post end point has been provided for point calculation

http://localhost:8080/apexsolutions/calculatedpoints

Json format for posting

{
  "dollarSpent": 120
}

----------------------------------------------------------------------

Swagger has been enabled to test end points

http://localhost:8080/apexsolutions/swagger-ui/index.html


Build Process

1. mvn clean
2. mvn compile
3. mvn package

a stand alone executable jar is created in the target directory

apexdiscountapp-0.0.1-SNAPSHOT.jar

run the jar
java -jar apexdiscountapp-0.0.1-SNAPSHOT.jar

-------------------------------------------------------
added docker support to project. Docker file is in base directory.

Build Docker image
docker build -f Dockerfile -t docker-spring-boot

Run Docker image
docker run -p 8080:8080  










