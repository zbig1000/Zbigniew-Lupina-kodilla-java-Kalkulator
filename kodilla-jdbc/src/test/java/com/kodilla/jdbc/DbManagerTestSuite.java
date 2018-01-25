package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUM\n" +
                "FROM USERS U\n" +
                "JOIN POSTS ON\n" +
                "USER_ID = U.ID\n" +
                "GROUP BY POSTS.USER_ID\n" +
                "HAVING (POSTS_NUM > 1)\n" +
                "ORDER BY U.ID;\n";

        try (
                Statement statement = dbManager.getConnection().createStatement();
                ResultSet rs = statement.executeQuery(sqlQuery)) {

            //Then
            int counter = 0;
            while (rs.next()) {
                System.out.println(
                        rs.getString("FIRSTNAME") + ", " +
                                rs.getString("LASTNAME") + ", " +
                                rs.getInt("POSTS_NUM"));
                counter++;
            }
            Assert.assertEquals(1, counter);
        }
    }

    @Test
    public void testPreparedStatement() throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT  U.FIRSTNAME, U.LASTNAME\n" +
                "FROM USERS U\n" +
                "WHERE FIRSTNAME = ?  OR LASTNAME = ?";
        String parameterName = "John";
        String parameterLastName = "Lee";

        try (
                Connection con = dbManager.getConnection();
                PreparedStatement seachUsername = con.prepareStatement(sqlQuery)) {

            seachUsername.setString(1, parameterName);
            seachUsername.setString(2, parameterLastName);

            ResultSet rs = seachUsername.executeQuery();

            //Then
            int counter = 0;
            while (rs.next()) {
                System.out.println(
                        rs.getString("FIRSTNAME") + ", " +
                                rs.getString("LASTNAME"));
                counter++;

            }
            Assert.assertEquals(3, counter);
        }
    }
}