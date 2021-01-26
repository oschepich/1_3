package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoJDBCImpl();

    //создания таблицы пользователей
    @Override
    public void createUsersTable() throws SQLException {
        userDao.createUsersTable();
    }

    //    удаления таблицы
    @Override
    public void dropUsersTable() throws SQLException {
        userDao.dropUsersTable();
    }

    //добавлен в базу данных
    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDao.saveUser(name, lastName, age);
    }

    //удаления пользователя по id
    @Override
    public void removeUserById(long id) throws SQLException {
        userDao.removeUserById(id);
    }

    //    сохранения пользователя/удаления или создания таблицы
    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    //    Метод очищения таблицы пользователей
    @Override
    public void cleanUsersTable() throws SQLException {
        userDao.cleanUsersTable();
    }
}




