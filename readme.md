# REST version of Spring Sample Application

This backend version of the Spring application only provides a REST API. **There is no UI**.

### Household ER Model

![alt petclinic-ermodel](doc/Database%20ER%20diagram.png)

## Running locally

### Database configuration

In its default configuration, this application use the MySQL database which gets populated at startup with data.

In your MySQL workbench, execute [sql scripts](sql) used to create tables and populate data.

For MySQL database, edit the [application.properties](src/main/resources/application.properties) file to match your local database name, user account and password.
```
spring.datasource.url=jdbc:mysql://localhost:3306/{Your Database Name}?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username={Your user name}
spring.datasource.password={Your password}
```

### Build application
```
mvn clean compile
```

### Running application
```
mvn
```