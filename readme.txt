








### Used links

https://mvnrepository.com/artifact/org.modelmapper/modelmapper/3.2.0

https://www.geeksforgeeks.org/java-spring-boot-microservices-example-step-by-step-guide/




build

gradlew.bat build (in root)

without test
gradlew.bat build -x test


docer build

docker build -t inspireai-userprofilingservice-image . (in root)


docker run

docker run -p 8080:8080 inspireai-userprofilingservice-image




CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    occupation VARCHAR(255),
    interests TEXT
);

INSERT INTO users (username, email, occupation, interests) VALUES ('JohnDoe', 'johndoe@example.com', 'Software Engineer', 'Programming, Reading');

INSERT INTO user (username, email) VALUES ('JaneSmith', 'janesmith@example.com');






### aws datastore

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://database-1.c7q6y0yscvdu.us-east-2.rds.amazonaws.com/srifoundation?useSSL=true&serverTimezone=UTC
spring.datasource.username=admin
spring.datasource.password=srifoundation1
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database=mysql
