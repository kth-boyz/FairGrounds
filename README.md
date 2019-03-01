# FairGrounds  
Project in Global Application Course at KTH (IV1201) by Peter Svensson, Christopher Robberts and Youssef Taoudi

## Tools
* Version control (Git)
* Project management (Maven)
* Test (Spring MVC Test Framework)
* Containerization (Docker)
* Continuous integration, CI (Travis)
* Cloud runtime (Heroku)

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
This application runs with a SQL database.
To create the database run the script `fairgrounds.sql` to build the database
The application connects to the database on the default port of `3306`
The username and password can be changed in the `application.properties` file


uploaded to heruko by travis

## Running Docker locally
1. CD into root
2. Build:
`docker build -t app .`
3. Run:
`docker run -p 8080:8080 -t app`

