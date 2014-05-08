# Project Quality Management System
	
## Preinstallation

1. [JDK 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)
2. [Maven 3](http://maven.apache.org/)
3. [Eclipse IDE for Java EE Developers](https://www.eclipse.org/downloads/)
4. [Tomcat 7](http://tomcat.apache.org/download-70.cgi)
5. [MySQL](http://www.mysql.com/)

## How to give it a go?

1. Clone this repositry
        
        git clone git@github.com:ibuziuk/bsuir-coursework.git
        
2. Buid it via maven
        
        mvn clean package
        
3. Run Eclipse and import project as a maven project
        
        File -> Import -> Existing Maven Project
        
4. Add Tomcat Server to Eclipse

5. Create db via MySql (Hibernate creates and updates the db schema, but it needs db being created first)
        
        name="project_managment_system" user="root" password="password"
        
6. Run the project on Tomcat Server from Eclipse
        
        Right-click on the project -> Run As.. -> Run on Server
