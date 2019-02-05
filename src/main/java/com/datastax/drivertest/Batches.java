package com.datastax.drivertest;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;

import static com.datastax.oss.driver.api.core.cql.DefaultBatchType.LOGGED;

public class Batches {

    public static void executeBatchStatement() {

        CassandraSession test1 = new CassandraSession();

        CqlSession session = test1.getSession();

        // Create simple statement to insert a user
        SimpleStatement simpleInsert =
                SimpleStatement.newInstance(
                        "INSERT INTO demo.users (lastname, age, city, email, firstname) VALUES ('Hicks', 28, 'Denver', 'raquelle@example.com', 'Raquelle')");

        // Create prepared statement to insert a user
        PreparedStatement preparedInsert =
                session.prepare(
                        "INSERT INTO demo.users" + "(lastname, age, city, email, firstname)"
                                + "VALUES (?,?,?,?,?);");

        // Create batch statement
        BatchStatement batch =
                BatchStatement.builder(LOGGED)
                        .addStatement(simpleInsert)
                        .addStatement(preparedInsert.bind("Jansson", 30, "Stockholm", "linda@example.com", "Linda"))
                        .addStatement(preparedInsert.bind("Gutermuth", 64, "Munich", "david@example.com", "David"))
                        .addStatement(preparedInsert.bind("Robinson", 21, "Toronto", "sarah@example.com", "Sarah"))
                        .build();


        session.execute(batch);





    }








}



