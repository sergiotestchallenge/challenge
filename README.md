1.BUILD AND RUN
---------------
Download all files in this repository
Build each springboot project with maven
Use a command prompt and locate in the directory "codechallenge"
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
