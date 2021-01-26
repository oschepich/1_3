package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection = Util.getConnection();
    User user = new User();

    public UserDaoJDBCImpl() {
    }

    //создания таблицы пользователей
    @Override
    public void createUsersTable() throws SQLException {
        try (Statement statement = Util.getConnection().createStatement();) {
            statement.executeUpdate("CREATE TABLE USER(id INTEGER PRIMARY KEY not NULL AUTO_INCREMENT, name VARCHAR(45), LastName VARCHAR (50), age INT not NULL)");
            System.out.println("Таблица создана");
        } catch (SQLSyntaxErrorException e) {
            System.out.println("Таблица уже существует");
        } catch (SQLException e) {
            System.out.println("Ошибка создания таблицы");
        }
    }

    ////    удаления таблицы
    @Override
    public void dropUsersTable() throws SQLException {

        try (Statement Statement = Util.getConnection().createStatement();) {
            Statement.executeUpdate("DROP TABLE USER");
        } catch (SQLSyntaxErrorException e) {
            System.out.println("Таблицы такой не существует");;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //добавлен в базу данных
   @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {

        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement("INSERT INTO USER (name, LastName, age) values (?,?,?)");) {
//            preparedStatement.setInt(1,'?');
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            System.out.println("Что то пошло не так при добавлении данных в таблицу");
        }

    }

    //удаления пользователя по id
    @Override
    public void removeUserById(long id) throws SQLException {

        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement("DELETE FROM USER WHERE ID=id");) {
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }

    //    сохранения пользователя/удаления или создания таблицы
    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();

        try (Statement statement = Util.getConnection().createStatement();) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USER");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                userList.add(user);
            }
        } catch (SQLException throwables) {
        }
        return userList;
    }

    //    Метод очищения таблицы пользователей
    @Override
    public void cleanUsersTable() throws SQLException {
        try (Statement statement = Util.getConnection().createStatement();) {
            statement.executeUpdate("TRUNCATE USER");
        } catch (SQLException throwables) {
        }
    }
}
