package ru.netology.springdb.demo;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctamplate", "root", "root");
        Statement statement = connection.createStatement();

//        statement.executeUpdate("insert into things (name) values ('Сгущёнка')");

        ResultSet resultSet = statement.executeQuery("select id, name from things");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.printf("Вещь %s №%d%n", name, id);
        }

        connection.close();
    }



}
