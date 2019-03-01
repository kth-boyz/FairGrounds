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

### Migration of data to new database
Old users in database migrated to new database.<br />
User "borg" - missing value in table "person" for ssnr and email, these are occuiped by placeholders - varchar "NULL"<br />
User "perstrand" - user didnt have username and password. A random password was generated for this user with the username "perstrand".<br />
Information about the new login credentials will be sent to the affected users.<br />
<br />
Passwords in the new database are encrypted with BCrypt - original cleartext passwords will be provided<br />

### Running Docker locally
1. CD into root
2. Build:
docker build -t app .
3. Run:
docker run -p 8080:8080 -t app