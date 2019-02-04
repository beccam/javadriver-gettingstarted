package com.datastax.drivertest;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;

import static com.datastax.oss.driver.api.core.cql.DefaultBatchType.LOGGED;

public class Batches {

    public static void executeBatchStatement() {

        CassandraSession test1 = new CassandraSession();

        CqlSession session = test1.getSession();

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





    }








}



