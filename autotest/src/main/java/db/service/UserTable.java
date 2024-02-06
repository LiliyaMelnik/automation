package db.service;

import db.crud.Crud;
import lombok.SneakyThrows;

import static java.lang.String.format;

public class UserTable extends Crud {

    public void insertAlice() {
        insert("INSERT INTO USERS (username, age) VALUES ('Alice', 20)");
    }

    public void updateAlice() {
        update("UPDATE USERS SET username='Ben' WHERE username='Alice'");
    }

    public void deleteAlice() {
        delete("DELETE FROM USERS WHERE username='Alice'");
    }

    public void deleteAllUsers() {
        delete("DELETE FROM USERS");
    }

    @SneakyThrows
    public String getBen() {
        var rs = select("SELECT * FROM USERS WHERE username='Ben'");
        if (rs.next()) {
            return rs.getString("username");
        }
        return ""; //no user
    }
    @SneakyThrows
    public String getAlice() {
        var rs = select("SELECT * FROM USERS WHERE username='Alice'");
        if (rs.next()) {
            return rs.getString("username");
        }
        return ""; //no user
    }

    @SneakyThrows
    public void selectAllUsers() {
        var rs = select("SELECT * FROM USERS");

        while (rs.next()) {
            String name = rs.getString("name");
            Integer age = rs.getInt("age");

            System.out.println(format("User - {username: %s, age: %d}", name, age));
        }
    }
}
