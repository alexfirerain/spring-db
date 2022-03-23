package ru.netology.springdb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CommandLineApp implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void run(String... args) {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("select * from customers");
        while (sqlRowSet.next())
            System.out.printf("№%s это %s%n",
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getString("name"));

        Thing thing = jdbcTemplate.queryForObject("select * from customers where id = ?",
                (rs, rowNum) -> new Thing(rs.getInt("id"), rs.getString("name")), 2);
        System.out.println(thing);

        Thing something = namedParameterJdbcTemplate.queryForObject("select * from customers where id = :id",
                Map.of("id", 3),
                (rs, rowNum) -> new Thing(rs.getInt("id"), rs.getString("name")));
        System.out.println(something);
    }

    public static class Thing {
        private int id;
        private String name;

        public Thing() {
        }

        public Thing(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Вещь №" + id + " это " + name;
        }
    }

}
