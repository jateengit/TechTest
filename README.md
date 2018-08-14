# TechTest

RESTful API that provides 3 operations

API Doc Endpoint (Swagger)
http://localhost:8080/swagger-ui.html

• Operation 1: Add a Customer
  Method: POST
  EndPoint: /customers
  Sample JSON:
  {
    "id":4,
    "firstName":"Jateen",
    "surName":"Udeshi"

  }


• Operation 2: Remove a Customer, given their ID
  Method: DELETE
  EndPoint: /customers/{id}

• Operation 3: List all Customers
  Method: GET
  EndPoint: /customers


Running Locally (Assuming Java/Maven are installed and configured in the classpath):

In project's base folder: TechTest

compile the source code of the project:
mvn compile

Install the build and run the automated test cases:
mvn install

Start service
java -jar target\techtest-0.0.1-SNAPSHOT.jar
