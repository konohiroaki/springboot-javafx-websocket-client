### springboot-javafx-websocket-client

This is a very simple demo app for showing how to implement a websocket client with spring-boot and javafx. This websocket client tries to access the following URL as a websocket server endpoint.

```
ws://localhost:8080/echo
```

### Usage
Same as usual.

```
mvn spring-boot:run
```

But you need to startup a websocket server before this, which provides `ws://localhost:8080/echo` as a endpoint.

You can use [springboot-websocket-server](https://github.com/konohiroaki/springboot-websocket-server) as a websocket server.

A GUI app will startup. You can easily understand the usage of the GUI app.

#### Create .jar
When you need a jar file, run

```
mvn clean package
```

and then run

```
java -jar the-jar-file.jar
```

### Fork me!
* For creating a new client using websocket and javafx
* For testing your websocket server
* For something awesome!

### Requires
* jdk1.8
