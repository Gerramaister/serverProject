### Introduction

This project is a web application that runs on the WildFly application server. It provides a RESTful API for managing
books. The application is built using Java EE technologies such as JAX-RS and JPA.
Requirements

To build, run, and deploy the application, you need to have the following software installed on your machine:

    Java SE Development Kit (JDK) 8 or later
    Apache Maven 3.3 or later
    WildFly 10.1 or later

Building the Application

To build the application, follow these steps:

- Open a terminal or command prompt.

- Navigate to the root directory of the project.

- Run the following command:
 

    mvn clean package

This command will build the application and create a WAR file in the target directory.

### Setup WildFly

In order to use the wildfly, we need to create a user.
In the Wildfly directory, there is a directory with the name bin.
So go to the bin directory.

If you have a Windows operating system, run the file add-user.bat from the
command line.
Follow the instructions. Choose (a), then give a name to the user and then a password.
Retype the password.
Then add the user to the management realm.
When asking:
Is this new user going to be used for one AS process to connect to another AS
process?
Answer no.

### Start WildFly

To start the server:
If you have Window, run standalone.bat
The server will start up.
In a web browser run this url:
`localhost:9990` (you need to log in)
You should be able to see the wildfly admin console.
or use this url:
`localhost:8080` and then choose ‘Management Console’

You will be in the Wildfly web admin console (you need to log in)

### Deploy application to Wildfly

Use the Management Console to deploy the application WAR-file that we have created earlier.

### API Endpoints

#### GET api/v1/book
returns a list of all the books in the database.

#### GET api/v1/book/{bookId}

returns a book object by its ID.

#### POST api/v1/book

adds a new book (in JSON format) to the database.

#### DELETE api/v1/book/{bookId}

removes a book from the database by its ID.

#### PUT api/v1/book/{bookId}

updates an existing book in the database.
