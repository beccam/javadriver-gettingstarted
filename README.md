# Getting Started with the Java Driver for Apache Cassandra
This repository was created as a guide to help Apache Cassandra users get started with the Datastax Java Driver

## Overview
This porject was created with IntelliJ and uses Maven to manage dependencies. You will need both the Java Driver core and Qurty Builder libraries 

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

`CqlSession session = CqlSession.builder().build();`

## Simple Statements

```session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");

session.execute("update users set age = 37 where lastname = 'Jones'");```

## Prepared Statements

## Query Builder

## Batch Statements

