package com.envision.spring.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectionUtil {

    private ThreadLocal<Connection> connectionLocal = new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() {
        try {
            if (connectionLocal.get() == null) {
                connectionLocal.set(dataSource.getConnection());
            }
            return connectionLocal.get();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void removeConnection() {
        connectionLocal.remove();
    }

}
