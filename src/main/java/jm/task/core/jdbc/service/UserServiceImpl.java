package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoHibernateImpl();

    //создания таблицы пользователей
    @Override
    public void createUsersTable() throws Exception {
        userDao.createUsersTable();
    }

    //    удаления таблицы
    @Override
    public void dropUsersTable() throws Exception {
        userDao.dropUsersTable();
    }

    //добавлен в базу данных
    @Override
    public void saveUser(String name, String lastName, byte age) throws Exception {
        userDao.saveUser(name, lastName, age);
    }

    //удаления пользователя по id
    @Override
    public void removeUserById(long id) throws Exception {
        userDao.removeUserById(id);
    }

    //    сохранения пользователя/удаления или создания таблицы
    @Override
    public List<User> getAllUsers() throws Exception {
        return userDao.getAllUsers();
    }

    //    Метод очищения таблицы пользователей
    @Override
    public void cleanUsersTable() throws Exception {
        userDao.cleanUsersTable();
    }
}




