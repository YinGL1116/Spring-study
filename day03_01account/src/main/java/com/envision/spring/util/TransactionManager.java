package com.envision.spring.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionManager {

    @Autowired
    private ConnectionUtil connectionUtil;

    public void begin() {
        try {
            connectionUtil.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void commit() {
        try {
            connectionUtil.getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void rollback() {
        try {
            Connection connection = connectionUtil.getConnection();
            connection.setAutoCommit(false);
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            connectionUtil.getConnection().close();
            connectionUtil.removeConnection();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
