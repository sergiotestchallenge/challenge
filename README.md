1.BUILD AND RUN
---------------

Download all files in this repository

Build each springboot project with maven and generate the jar file inside a target directory.

Use a command prompt and locate in the main directory

Run the follow commands:

docker build --tag suscribers-public:1.0 challenge-public

docker build --tag suscribers-email:1.0 challenge-email

docker build --tag suscribers:1.0 challenge

docker network create mynet

docker container run --network mynet --name suscribers-email suscribers-email:1.0

docker container run -p 9000:9000 --network mynet --name suscribers-public suscribers-public:1.0

docker container run --network mynet --name suscribers suscribers:1.0


2.USE:
------
You could send a post using the endpoint http://localhost:9000/suscriptions

Example of json request:

{
  "email": "sergioc555@gmail.com",
  "firstName": "sergio",
  "gender": "male",
  "dateOfBirth": "1989-10-25T00:00:00.000Z",
  "flag": 1,
  "newsLetterId": 53
}

More documentation of the endpoint in http://localhost:9000/swagger-ui.html

3.LIBRARIES
------------
spring-cloud-starter-openfeign	:	it is a declarative web service client, I used it because is easy to use and it allows you to save a lot of time.

spring-boot-starter-data-jpa	:	it allows you to manage access to the database layer, I used it because is easy to use and it allows you to save a lot of time.

lombok							:	it generates getters and setters and help with logs and other useful functions and patterns like builder.

h2								:	it is an in-memory database, I used it for saving more time than setting up a normal database

springfox-swagger2/springfox-swagger-ui				:	it help you to document your API's

javax.mail						:	it is an API that allows you to write and send emails. I used it because is tha most popular API to send mails in Java.
