# Customer

The purpose of this microservice is to create a insurance contract for a given customer. This is done in the following path:
- a non-existing frontend contacts this microservice via a resource endpoint and asks for a contract for a customer of given name
- get the customer Id for the customer name via a client connecting to a non-existing microservice
- get the contract Id for the customer Id via the above client, but to a different endpoint
- create the contract object
- send the contract to a non-existing delivery microservice via a client
- return the contract to a non-existing frontend service in a JSON format

How to start the Customer application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/customerservice-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

List of resource endpoints
---
http://localhost:8080/contract/{customerName}