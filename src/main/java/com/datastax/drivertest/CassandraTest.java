package com.datastax.drivertest;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;

public class CassandraTest {


    public static void main(String[] args) {

        CassandraSession test1 = new CassandraSession();

        CqlSession session = test1.getSession();

        // Insert one record into the users table
        session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");

        // Use select to get the user we just entered
        ResultSet rs = session.execute("SELECT * FROM users WHERE lastname='Jones'");
        for (Row row : rs) {
            System.out.format("Output after simple insert: %s %d\n", row.getString("firstname"), row.getInt("age"));
        }

        // Update the same user with a new age
        session.execute("update users set age = 36 where lastname = 'Jones'");

        // Select and show the change
        rs = session.execute("select * from users where lastname='Jones'");
        for (Row row : rs) {
            System.out.format("Output after simple update: %s %d\n", row.getString("firstname"), row.getInt("age"));
        }

        // Delete the user from the users table
        session.execute("DELETE FROM users WHERE lastname = 'Jones'");
        // Show that the user is gone
        rs = session.execute("select * from users where lastname='Jones'");
        for (Row row : rs) {
            System.out.format("Output after simple delete: %s %d %s %s %s\n", row.getString("lastname"), row.getInt("age"),  row.getString("city"), row.getString("email"), row.getString("firstname"));
        }


        // Insert one record into the users table
        PreparedStatement prepared  = session.prepare(

                "INSERT INTO demo.users" + "(lastname, age, city, email, firstname)"
                        + "VALUES (?,?,?,?,?);");

        BoundStatement bound = prepared.bind("Walsh", 40, "Santa Fe", "kate@example.com", "Kate");

        session.execute(bound);


        QueryBuilder insert = new QueryBuilder();

        insert.executeQueryBuilder();



        Batches inserts = new Batches();

        inserts.executeBatchStatement();

     /*
            ResultSet results = session.execute("SELECT * FROM users");
            for (Row row : results) {
                System.out.format("%s %d %s %s %s\n", row.getString("lastname"), row.getInt("age"),
                        row.getString("city"), row.getString("email"), row.getString("firstname"));

                }
     */
        }
    }




