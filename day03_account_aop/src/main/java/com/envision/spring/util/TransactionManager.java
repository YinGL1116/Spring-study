package com.envision.spring.util;

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

    /**
     * commit() 方法用于使当前事务中的更改成为持久的更改，并释放 Connection 对象当前持有的所有数据库锁。
     * 此方法只有在手动事务的模式下才可以用。
     */
    public void commit() {
        try {
            connectionUtil.getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void rollback() {
        try {
            connectionUtil.getConnection().rollback();
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
