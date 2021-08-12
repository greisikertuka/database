package com.example.Login.a;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    public static void main (String[] args) throws SQLException {
try {
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprove", "root", "");
    Statement stmt = con.createStatement();
    String sqlDelete = "delete from user where id < 8";
    System.out.println("The SQL statement is: " + sqlDelete + "\n");  // Echo for debugging
    int countDeleted = stmt.executeUpdate(sqlDelete);
    System.out.println(countDeleted + " records deleted.\n");
    String sqlInsert = "insert into user values "
            + "(6, 'Kristina'),"
            + "(45, 'Mira')";
    System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
    int countInserted = stmt.executeUpdate(sqlInsert);
    System.out.println(countInserted + " records inserted.\n");
}
catch (Exception e){
    e.printStackTrace();
}
    }
}