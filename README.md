## Database connection:
##### Currently MYSQL is configure with msql driver
##### db.driver=com.mysql.cj.jdbc.Driver
##### db.url=jdbc:mysql://localhost:3306/testdb
##### db.user=admin
##### db.password=admin
 
## TO Change DB driver, url , username or  Pass 
##### Please change in config.properties file in src\main\resources and re-package
#### -----------------------------------------------------------------------------

## To Create and find executable Jar
##### 1. cmd in project root folder
##### 2. run "mvn clean"
##### 3. run "mvn install"

##### It will create fresh jar in \target folder as name test-0.0.1-SNAPSHOT-jar-with-dependencies.jar

#### -----------------------------------------------------------------------------
## To run executable
##### run cmd in \target folder 
##### java -jar test-0.0.1-SNAPSHOT-jar-with-dependencies.jar


