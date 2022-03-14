package ru.netology.springdb.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:jdbctamplate", "root", "root");
        Statement statement = connection.createStatement();

        statement.executeUpdate("insert into things (name) values ('Сгущёнка')");



    }



}
