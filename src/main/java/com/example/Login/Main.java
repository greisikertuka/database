package com.example.Login;
import java.sql.*;
public class Main {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static String url="jdbc:mysql://localhost:3306/dbprove";
    private static String user="root",pass="";
    public static void main(String[] args) {

        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection(url,user,pass);

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from user");
            int i=0;
            while (resultSet.next()){
                    int id=resultSet.getInt(1);
                    String name=resultSet.getString(2);
                    System.out.println((id-4) + "-> Elementi i "+(i+1)+": " + name);
                    i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
