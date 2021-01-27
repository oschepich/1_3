package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) throws Exception {
        UserService userService = new UserServiceImpl();
//  Создание таблицы user
        userService.createUsersTable();

//  Добавление 4 user в таблицу
        userService.saveUser("Пуфик", "Манукян", (byte) 33);
        userService.saveUser("Тофик", "Манукиян", (byte) 32);
        userService.saveUser("Чачик", "Мисукян", (byte) 31);
        userService.saveUser("Ара", "Марунян", (byte) 37);

//  Вывод всех узеров из таблицы в консоль
        System.out.println(userService.getAllUsers().toString());

//        очистка строки по id
        userService.removeUserById(3);

//         Очитка таблицы
        userService.cleanUsersTable();

//  Удаление таблицы из БД
        userService.dropUsersTable();
    }

}
