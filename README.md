run from local

set respective profile to run and update configuration for respective env

set server.port to your choice as of now local et to 9090 and other profiles are set by default to 8080


-Dspring.profiles.active=local


once up the server then open in memory H2 database ui on browser to connect 

Run Spring Boot application with command: mvn spring-boot:run

Let’s open H2 console with url: http://localhost:9090/h2-ui

once all are set the open postman and test  post,get operations  


BookingInventoryOrder Service  (monolithic package structure )

com.database.sample

com.database.sample.order.controller
com.database.sample.order.service
com.database.sample.order.entity

com.database.sample.inventory.controller
com.database.sample.inventory.service
com.database.sample.inventory.entity

com.database.sample.booking.controller
com.database.sample.booking.service
com.database.sample.booking.entity


order microservice 1 package structure

com.database.sample
com.database.sample.order.controller
com.database.sample.order.service
com.database.sample.order.entity

inventory microservice 2 package structure

com.database.sample
com.database.sample.inventory.controller
com.database.sample.inventory.service
com.database.sample.inventory.entity

booking microservice 3 package structure

com.database.sample
com.database.sample.booking.controller
com.database.sample.booking.service
com.database.sample.booking.entity

