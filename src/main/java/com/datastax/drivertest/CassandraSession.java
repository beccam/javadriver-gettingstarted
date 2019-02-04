package com.datastax.drivertest;

import com.datastax.oss.driver.api.core.CqlSession;




public class CassandraSession {

    private static CqlSession session = null;

            CqlSession getSession() {

                CqlSession session = CqlSession.builder().build();

                return session;
           }


}
