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

The entry point to your Cassandra cluster is through the `CqlSession`

```java
CqlSession session = CqlSession.builder().build();
```

## Simple Statements

`session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");`

`session.execute("update users set age = 37 where lastname = 'Jones'");`

## Prepared Statements
```java
PreparedStatement prepared  = session.prepare(

                "INSERT INTO demo.users" + "(lastname, age, city, email, firstname)"
                        + "VALUES (?,?,?,?,?);");

        BoundStatement bound = prepared.bind("Hudson", 40, "Santa Fe", "kate@example.com", "Kate");

        session.execute(bound);
```
## Query Builder
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
