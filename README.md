# FairGrounds  
Project in Global Application Course at KTH (IV1201) by Peter Svensson, Christopher Robberts and Youssef Taoudi

## Tools
* Version control (Git)
* Project management (Maven)
* Test (Spring MVC Test Framework)
* Containerization (Docker)
* Continuous integration, CI (Travis)
* Cloud runtime (Heroku)
* SQL
* Postgresql

## Frameworks
* Spring Boot
* Spring Security
* Spring Web MVC
* Thymeleaf
* Spring Data (JPA)

## Migration of data to new database
Old users in database migrated to new database.<br />
Users with missing value in table `person`, these are occuiped by placeholders - varchar `NULL`<br />
Users without username and password; a random password was generated for this user with the username "perstrand".<br />
Information about the new login credentials will be sent to the affected users.<br />
<br />
Passwords in the new database are encrypted with BCrypt - original cleartext passwords are provided in script as comment<br />

## Database
This application runs with three different databases. Comment or uncomment the databse that you would like to use when running the application by using `#` in the `application.properties` file. The datasases are labeled. PostgresSQL for Heroku launch only<br />
<br />
*H2 inmemory database<br />
Only used for testing application. This database is full of dummy data only used for testing the system.<br />
<br />
*SQL database<br />
To create the database run the script `fairgrounds.sql` to build the database
The application connects to the database on the default port of `3306`
The username and password can be changed in the `application.properties` file.<br />
<br />
*PostgreSQL<br />
To run the program on heroku with a database, postgresql must be used. Create the database using the script 'postgresdump' and port it to your heroku server and use the postgres properties in 'application.properties'. Make sure the URL, password and username match those shown in the database credentials on the heroku dashboard.<br />
<br />
The 'herokudump.sh' file can be ran to transfer the postgresdump to the heroku server


## Launching application on Heroku
To launch application on the Heroku server, push to master branch.
The script `.travis.yml` will launch the application to the CI server, Travis.
Travis, in turn, will deploy the application on the Heroku server.

## Run Application locally

Run the command `java -Dserver.port=$PORT $JAVA_OPTS -jar target/FairGrounds-1.0-SNAPSHOT.jar`

## Running Docker locally
1. CD into root
2. Build:
`docker build -t app .`
3. Run:
`docker run -p 8080:8080 -t app`

