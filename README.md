Project is target packaged as target.war (deployed at tomcat_home/webapp folder)

Creating myRetails Restful Service.

Technology Stack used :

1.	Spring 4.1.0 (spring-core,spring-web,spring-webmvc,spring-data-jpa,spring data mongodb)
2.	Ehcache (spring-context-support,spring-oxm,ehcache)
3.	Logger(log4j1.2.14, slf4j-api)
4.	Java servlet,Database pooling, Cglib (for run time)
5.	Hibernate & JPA (jpa-api,hibernate-entitymanager,hibernate validator)
6.	MYSQL connector &  MongoDB driver
7.	Java 1.8
8.	apache-tomcat-8.0.35 (Application Server)
9.	MySQL database & Mongo database
10.	
Build Environment :  Maven version 4.0 

Steps to Build Project

A) Install Maven 4.0 

B) Set classpath till maven home or Import whole project in STS/eclipse. 

C) Go to command prompt reach till target  
       for eg : c:/target & 
     run command :
        mvn clean install  -Dmaven.test.skip=true
        
D) It will create folder new folder target under target which holds target.war

E) Deploy target.war under tomcat_home/webapp folder

F) Make sure Mongodb must have started & have database test as well as mysql5.0 must have database test.

        1) MYSQL Database : must have  database name : test
        		Table : Product
              Columns are : PId &  ProductName 
              Data are :  1,Sample
        2) MongoDb database must have database name test
  		         Table : ProductPrice
            Columns are : PId &  ProductPrice 
            Data are :  1,0

G) Now start tomcat using startup.bat in bin folder

Request :   GET

URL : http://localhost:8080/target/product/1 

Output : {"success":true,"productList":[{"pId":1,"productName":"Sample","price":0.0}]}

Request : PUT

URL:http://localhost:8080/target/product/1 

Input : {"pId":1,"productName":"Sample","price":30.0}

Output :{"success":true,"productList":[{"pId":1,"productName":"Sample","price":30.0}]}



