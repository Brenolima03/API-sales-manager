# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

###
If you don't have Java or have an outdated version use the following commands:
* sudo apt update
* sudo apt install maven
* sudo apt install openjdk-21-jdk
* sudo nano /etc/environment
* JAVA_HOME="/usr/lib/jvm/jdk-21-oracle-x64/bin/java"
* source /etc/environment (Apply the path)
* echo $JAVA_HOME (Check if the newer Java was successfully installed and set to default)

### Steps for creating a class
* Entity;
* Resource;
* Repository;
* Service.
* When in doubt, follow the alphabetical order.

### Commands
mvn spring-boot:run (initiate Spring Boot)

http://localhost:8080/

git add .
git commit -m 'adding index.html'
git push
