package com.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String USERNAME = "engneAdmin";
    private static final String PASSWORD = "1qaz2wsx3edc";
    private static final String URL = "jdbc:mysql://localhost:3306/business?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String args[]) throws SQLException {
        //соединение с БД
        Connection connection = null;
        Driver driver;

//        //на случай если невозможно создать драйвер
//        try{
//            //создаем драйвер
//            driver = new FabricMySQLDriver();
//        } catch (SQLException exc){
//            System.out.println("Произошла ошибка при создание драйвера...");
//            return;
//        }

        try   {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        }
        catch (SQLException e1) {
            System.out.println("Драйвер не зарегистрировался");
            return;
        }

//        //зарегестрировать драйвер
//        try{
//            DriverManager.registerDriver(driver);
//        } catch (SQLException exc){
//            System.out.println("Не удалось зарегестрировать драйвер...");
//            return;
//        }

        //передаем имя пользователя и пароль в коннектор and URL
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed())
                System.out.println("Соединение установлено");

            System.out.println("code...");
        } catch (SQLException exc){
            System.out.println("Не удалось создать соединение...");
            exc.printStackTrace();
            return;
        } finally { //данный блок выполняется в любом случае, блок для закрытия соединения
            if(connection != null)
                connection.close();
        }

    }
}

