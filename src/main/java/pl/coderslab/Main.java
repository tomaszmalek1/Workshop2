package pl.coderslab;

import pl.coderslab.entity.UserDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DbUtil.getConnection()) {

            String CREATE_USER_QUERY =
                    "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
            UserDao.insert(conn, CREATE_USER_QUERY, "tomasz", "tomasz@wp.pl", "hasło");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
