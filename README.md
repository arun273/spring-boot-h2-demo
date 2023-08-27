run from local

set respective profile to run and update configuration for respective env

set server.port to your choice as of now local et to 9090 and other profiles are set by default to 8080


-Dspring.profiles.active=local


once up the server then open in memory H2 database ui on browser to connect 

Run Spring Boot application with command: mvn spring-boot:run

Let’s open H2 console with url: http://localhost:9090/h2-ui

once all are set the open postman and test  post,get operations  