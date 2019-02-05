package com.datastax.drivertest;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;

import static com.datastax.oss.driver.api.core.cql.DefaultBatchType.LOGGED;

public class Batches {

    public static void executeBatchStatement() {

        CassandraSession test1 = new CassandraSession();

        CqlSession session = test1.getSession();

        // TO DO: Create simple statement to insert a user

        // TO DO: Create prepared statement to insert a user

        // TO DO: Create batch statement




    }



}



