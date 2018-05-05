package com.alpha;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArrayTypeHandler implements TypeHandler {
    private static Cooperator[] cooperators;

    public ArrayTypeHandler() {
        cooperators = new Cooperator[]{new Cooperator(),new Cooperator()};
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Object t, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Object getResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("***********" + s + "*********");

        if (s.equals("cooperator1_name")) {
            cooperators[0].setName(resultSet.getString(s));
        }
        if (s.equals("cooperator1_email")) {
            cooperators[0].setEmail(resultSet.getString(s));
        }
        if (s.equals("cooperator2_name")) {
            cooperators[1].setName(resultSet.getString(s));
        }
        if (s.equals("cooperator2_email")) {
            cooperators[1].setEmail(resultSet.getString(s));
        }

        return cooperators;
    }

    @Override
    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
