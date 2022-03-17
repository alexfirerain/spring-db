package ru.netology.springdb.demo;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctemplate", "root", "fuck");
        Statement statement = connection.createStatement();

        statement.executeUpdate("insert into things (name) values ('Сгущёнка')");

        ResultSet resultSet = statement.executeQuery("select id, name essence from things");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("essence");
            System.out.printf("Вещь %s №%d%n", name, id);
        }

        connection.close();
    }



}
