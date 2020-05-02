# Kafka Sample Environment

## Pre-requisites to run
- Docker
- Docker-compose
- Java 8+
- Gradle

# Running the Kafka Server

Just edit `docker-compose.yaml` at `KAFKA_CFG_ADVERTISED_LISTENERS`, edit `192.168.0.3` to represent your local IP Address. This is necessary because since we're running Kafka inside a container, by default, it will register itself at ZooKeeper with the Container Hostname.
You can use localhost, but then, Kafdrop won't be able to connect to it.

That being said, just run
```bash
docker-compose up -d
```

This will setup:
- ZooKeeper
- Kafka
- Kafdrop (At http://localhost:9000)

# Running the Micronaut Application

Just run the application with:
```bash
./gradlew run
```

This application consists of 3 components:
- A Kafka Producer, that will send messages to a `my-products` topic
- A Kafka Listener, that will listen to messages at `my-products` topic
- An HTTP Endpoint at http://localhost:8080/product ,to allow you to easily send messages to your topic


After the application is running, you can send messages by sending a `POST` to http://localhost:8080/product with the body:

```json
{
	"brand": "Nike",
	"name": "Future Shoes 3"
}
```

You can check in your application console, that your Kafka Listener got the record, and printed it to the console.

# Visualizing your Kafka Cluster with Kafdrop

You can access http://localhost:9000 to see all of your Kafka Clusteri information (Topics, Consumers, Partitions, etc)

![Kafdorp Image](images/kafdrop.png)