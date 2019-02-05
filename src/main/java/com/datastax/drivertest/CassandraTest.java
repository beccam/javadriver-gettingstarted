package com.datastax.drivertest;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;

public class CassandraTest {


    public static void main(String[] args) {

        CassandraSession test1 = new CassandraSession();

        CqlSession session = test1.getSession();

        // TO DO: Insert one record into the users table


        // TO DO: Use select to get the user we just entered


        // TO DO: Update the same user with a new age


        // TO DO: Select and show the change


        // TO DO: Delete the user from the users table


        // TO DO: Show that the user is gone


        // TO DO: Insert one record into the users table



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

     session.close();
        }
    }




