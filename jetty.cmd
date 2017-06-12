set MONGO_URL=mongodb://localhost:27017/spring-mongo

call java -Xdebug -Xrunjdwp:transport=dt_socket,address=8585,server=y,suspend=n -jar target/dependency/jetty-runner.jar  --port 9090 target/*.war