package com.kodilla.jdbc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import static org.junit.Assert.assertEquals;

public class StoredPostTestSuite  {
    private DbManager dbManager;
    private Statement statement;

    @Before
    public void prepareTest() throws SQLException, InterruptedException {
        dbManager = DbManager.getInstance();
        statement = dbManager.getConnection().createStatement();
    }

    @After
    public void closeTest() throws SQLException {
        statement.close();
    }

//    @Test
    public void testUpdateVipLevels() throws SQLException {
        //Given
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        statement.executeUpdate(sqlUpdate);
        //When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.executeUpdate(sqlProcedureCall);
        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
    }

//    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER=FALSE";
        statement.executeUpdate(sqlUpdate);
        //When
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);
        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER=FALSE";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(2, howMany);
    }

}
