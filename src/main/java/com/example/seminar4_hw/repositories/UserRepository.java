package com.example.seminar4_hw.repositories;

import com.example.seminar4_hw.model.MagicData;
import com.example.seminar4_hw.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Репозиторий для запросов к БД сущности пользователей
 */
@Repository
public class UserRepository {

    /**
     * Объект подключения к БД
     */
    private final JdbcTemplate jdbc;

    /**
     * туда подключены sql запросы, которые будут убраны из этого класса
     */
    private final MagicData magicData;

    /**
     * Конструктор класса
     * @param jdbc
     */
    public UserRepository(JdbcTemplate jdbc, MagicData magicData) {
        this.jdbc = jdbc;
        this.magicData = magicData;
    }

    // Получение всех пользователей из базы данных
    public List<User> findAll(){
        //String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastname"));
            return rowObject;
        };
        return jdbc.query(magicData.getFindAll(), userRowMapper);
    }

    //Добавление в базу данных
    public User save(User user){
        //String sql = "INSERT INTO userTable (firstName, lastName) VALUES (?, ?)";//"INSERT INTO userTable VALUES (NULL, ?, ?)";
        jdbc.update(magicData.getSave(), user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Удаление пользователя из базы по id
     * @param id
     */
    public void delete(int id){
        //String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(magicData.getDelete(), id);
    }

    /**
     * Обновление пользователя в БД
     * @param user объект пользователя с измененными данными
     */
    public void update(User user){
        //String sql = "UPDATE userTable SET firstName = ?, lastname = ? WHERE id=?";
        jdbc.update(magicData.getUpdate(), user.getFirstName(), user.getLastName(), user.getId());
    }

    /**
     * Поиск пользователя по id
     * @param id
     * @return
     */

    public User findUserById(int id){
        //String sql = "SELECT * FROM userTable WHERE id=" + id;
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastname"));
            return rowObject;
        };
        List<User> list = jdbc.query(magicData.getFindById() + id, userRowMapper);
        if (list.size() > 0) {
            return list.get(0);
        }
        else {
            return null;
        }
    }
}


