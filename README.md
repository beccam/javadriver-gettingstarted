# Getting Started with the Java Driver for Apache Cassandra
This repository was created as a guide to help Apache Cassandra users get started with the Datastax Java Driver

## Overview
This project was created with IntelliJ and uses Maven to manage dependencies. You will need both the Java Driver core and Qurty Builder libraries to your POM file. 

     <dependency>
            <groupId>com.datastax.oss</groupId>
            <artifactId>java-driver-core</artifactId>
            <version>4.0.0-beta3</version>
        </dependency>
        <dependency>
            <groupId>com.datastax.oss</groupId>
            <artifactId>java-driver-query-builder</artifactId>
            <version>4.0.0-beta3</version>
        </dependency>

## Connect to your Cassandra cluster

The entry point to your Cassandra cluster is through the `CqlSession`. It holds the known state of the actual Cassandra cluster, and is what you use to execute queries.`CqlSession.builder()` provides a fluent API to create an instance programmatically. 
```java
CqlSession session = CqlSession.builder().build();
```

## Simple Statements
In this sample project, we will manipulate enteries in a simple `users` table, using the Java driver. Use SimpleStatement for queries that will be executed only once (or just a few times). It is a simple implementation built directly from a character string. 

`session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");`

`session.execute("update users set age = 37 where lastname = 'Jones'");`

## Prepared Statements
Use prepared statements for queries that are executed multiple times in your application. When you prepare the statement, Cassandra parses the query string, caches the result and returns a unique identifier (the PreparedStatement object keeps an internal reference to that identifier).
```java
PreparedStatement prepared  = session.prepare(

                "INSERT INTO demo.users" + "(lastname, age, city, email, firstname)"
                        + "VALUES (?,?,?,?,?);");

        BoundStatement bound = prepared.bind("Hudson", 40, "Santa Fe", "kate@example.com", "Kate");

        session.execute(bound);
```
## Query Builder
The query builder is a utility to generate CQL queries programmatically. For example, it could be used to:

 * given a set of optional search parameters, build a search query dynamically depending on which parameters are provided;
 * given a Java class, generate the CRUD queries that map instances of that class to a Cassandra table.
```java
Insert insert = insertInto("users")
                .value("firstname", literal("Cornelia"))
                .value("lastname", literal("Grimsmo"))
                .value("age", literal(26))
                .value("email", literal("cornelia@example.com"))
                .value("city", literal("Oslo"));


        SimpleStatement statement = insert.build();

        session.execute(statement);
```

## Batch Statements
Use BatchStatement to execute a set of queries as an atomic operation. Batches can contain any combination of simple statements and bound statements.
```java
SimpleStatement simpleInsert =
                SimpleStatement.newInstance(
                        "INSERT INTO demo.users (lastname, age, city, email, firstname) VALUES ('Hicks', 28, 'Park City', 'raquelle@example.com', 'Raquelle')");

        PreparedStatement preparedInsert =
                session.prepare(
                        "INSERT INTO demo.users" + "(lastname, age, city, email, firstname)"
                                + "VALUES (?,?,?,?,?);");


        BatchStatement batch =
                BatchStatement.builder(LOGGED)
                        .addStatement(simpleInsert)
                        .addStatement(preparedInsert.bind("Juhola", 30, "Stockholm", "linda@example.com", "Linda"))
                        .addStatement(preparedInsert.bind("Marx", 64, "Trier", "karl@example.com", "Karl"))

                        .build();


        session.execute(batch);
```        
