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

        // Insert one record into the users table
        Insert insert = insertInto("users")
                .value("firstname", literal("Therese"))
                .value("lastname", literal("Fredriksen"))
                .value("age", literal(26))
                .value("email", literal("therese@example.com"))
                .value("city", literal("Oslo"));


        SimpleStatement statement = insert.build();

        session.execute(statement);

        // Use select to get the user we just entered
        Select select = selectFrom("users").all().whereColumn("lastname").isEqualTo(literal("Fredriksen"));

        SimpleStatement stmt = select.build();

        // Show results
        ResultSet rs = session.execute(stmt);
        for (Row row : rs) {
            System.out.format("Output from QueryBuilder: %s %d\n", row.getString("firstname"), row.getInt("age"));
        }


    }
}
