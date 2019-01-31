package drivertest;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.insert.Insert;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilderDsl.insertInto;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilderDsl.literal;

public class QueryBuilder {

    public static void executeQueryBuilder() {

        CassandraSession test1 = new CassandraSession();

        CqlSession session = test1.getSession();

        Insert insert = insertInto("users")
                .value("firstname", literal("Cornelia"))
                .value("lastname", literal("Grimsmo"))
                .value("age", literal(26))
                .value("email", literal("cornelia@example.com"))
                .value("city", literal("Oslo"));


        SimpleStatement statement = insert.build();

        session.execute(statement);
    }
}
