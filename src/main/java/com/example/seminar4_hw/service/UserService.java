package com.example.seminar4_hw.service;

import org.springframework.stereotype.Service;
import com.example.seminar4_hw.model.User;
import com.example.seminar4_hw.repositories.UserRepository;

import java.util.List;

/**
 * Предоставляет определенные возможности  подключения к работе с базами данных
 * Логика работы с User
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Получение всех пользователей из репозитория
    public List<User> findAll(){
        return userRepository.findAll();
    }

    //Сохранение пользователя в репозитории
    public User saveUser(User user){
        return userRepository.save(user);
    }

    /**
     * Получение пользователя по id
     * @param id
     * @return
     */
    public User getUserById(Integer id){
        return userRepository.findUserById(id);
    }

    /**
     * Удаление пользователя
     * @param id
     */
    public void deleteById(int id){
        userRepository.delete(id);
    }

    /**
     * Изменение данных пользователя
     * @param user
     */
    public void updateUser(User user){
        userRepository.update(user);
    }
}


