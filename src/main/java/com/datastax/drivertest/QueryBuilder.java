package com.datastax.drivertest;


import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.insert.Insert;
import com.datastax.oss.driver.api.querybuilder.select.Select;


import static com.datastax.oss.driver.api.querybuilder.QueryBuilderDsl.insertInto;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilderDsl.selectFrom;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilderDsl.literal;

public class QueryBuilder {

    public static void executeQueryBuilder() {

        CassandraSession test1 = new CassandraSession();

        CqlSession session = test1.getSession();

        // TO DO: Insert one record into the users table



        // TO DO: Use select to get the user we just entered


        // TO DO: Show results

        }


    }

