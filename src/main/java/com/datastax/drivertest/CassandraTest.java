package com.datastax.drivertest;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;

public class CassandraTest {


    public static void main(String[] args) {

        CassandraSession test1 = new CassandraSession();

        CqlSession session = test1.getSession();

        session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");


        session.execute("update users set age = 37 where lastname = 'Jones'");

        PreparedStatement prepared  = session.prepare(

                "INSERT INTO demo.users" + "(lastname, age, city, email, firstname)"
                        + "VALUES (?,?,?,?,?);");

        BoundStatement bound = prepared.bind("Hudson", 40, "Santa Fe", "kate@example.com", "Kate");

        session.execute(bound);

        session.execute("DELETE FROM demo.users WHERE lastname = 'Jones'");

        QueryBuilder test2 = new QueryBuilder();

        test2.executeQueryBuilder();


        Batches test3 = new Batches();

        test3.executeBatchStatement();



            ResultSet results = session.execute("SELECT * FROM users");
            for (Row row : results) {
                System.out.format("%s %d %s %s %s\n", row.getString("lastname"), row.getInt("age"),
                        row.getString("city"), row.getString("email"), row.getString("firstname"));



                }
        }
    }




