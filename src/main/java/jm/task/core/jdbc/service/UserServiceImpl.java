package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.List;

public class UserServiceImpl implements UserService {

    Connection connection = Util.getConnection();
    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    //создания таблицы пользователей
    public void createUsersTable() throws SQLException {
        userDaoJDBC.createUsersTable();
    }

    //    удаления таблицы
    public void dropUsersTable() throws SQLException {
        userDaoJDBC.dropUsersTable();
    }

    //добавлен в базу данных
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDaoJDBC.saveUser(name, lastName, age);
    }


    //удаления пользователя по id
    public void removeUserById(long id) throws SQLException {
        userDaoJDBC.removeUserById(id);
    }

    //    сохранения пользователя/удаления или создания таблицы
    public List<User> getAllUsers() throws SQLException {
        return userDaoJDBC.getAllUsers();
    }

    //    Метод очищения таблицы пользователей
    public void cleanUsersTable() throws SQLException {
        userDaoJDBC.cleanUsersTable();

    }
}