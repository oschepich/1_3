package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.*;

public class Main {


    public static void main(String[] args) throws SQLException {
        UserServiceImpl u = new UserServiceImpl();
//  Создание таблицы user
        u.createUsersTable();

//  Добавление 4 user в таблицу
        u.saveUser("Пуфик", "Манукян", (byte) 33);
        u.saveUser("Тофик", "Манукиян", (byte) 32);
        u.saveUser("Чачик", "Мисукян", (byte) 31);
        u.saveUser("Ара", "Марунян", (byte) 37);

//  Вывод всех узеров из таблицы в консоль
        System.out.println(u.getAllUsers().toString());

//  Очитка таблицы
        u.cleanUsersTable();

//  Удаление таблицы из БД
        u.dropUsersTable();


    }
}
