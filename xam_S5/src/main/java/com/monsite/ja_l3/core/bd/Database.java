package com.monsite.ja_l3.core.bd;


import java.sql.*;

public interface Database {
    void openConnexion() ;

    void closeConnexion() ;

    ResultSet executeSelect() throws SQLException;

    int executeUpdate() throws SQLException;

    void initPreparedStatement(String sql) throws SQLException;
     
}
