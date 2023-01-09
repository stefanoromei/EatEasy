package logic.model;

import logic.Main;
import logic.exception.DatabaseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static logic.model.Users.NOT_LOGGED;
import static logic.model.Users.USER;

public class Database {

    private static Connection conn;

    private static Users user;

    private Database(){

    }

    public static Connection getConnection() throws DatabaseException {
        if(conn == null) {
            conn = connect(NOT_LOGGED);
        }
        return conn;
    }

    private static Connection connect(Users user) throws DatabaseException {
        URL url = Main.class.getResource("/EatEasyDB_conf.txt");
        File fileConfig = new File(url.getPath());
        try (var myReader = new Scanner(fileConfig)) {
            if (user == USER) {
                Database.user = USER;
            } else {
                Database.user = NOT_LOGGED;
            }
            var conf = new String[4];
            var i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                conf[i] = data;
                i++;
            }
            Class.forName(conf[1]);
            conn = DriverManager.getConnection(conf[0], conf[2], conf[3]);
        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            throw new DatabaseException();
        }
            return conn;
    }
}
