package com.example.seminar4_hw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.seminar4_hw.model.User;
import com.example.seminar4_hw.service.UserService;

import java.util.List;

/**
 * Ответы на запросы от браузера
 * Объект сервиса для работы с пользователями
 */

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Получение данных с базы данных
    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user-list";
    }

    //Создание нового пользователя
    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    /**
     * Получение данных о новом пользователе с формы представления
     * @param user объект пользователя с заполненными полями
     * @return перенаправление на страницу со списком пользователей
     */
    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * удаление пользователя
     * @param id
     * @return перенаправление на страницу со списком пользователей
     */
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    /**
     * Изменение данных пользователя
     * @param id
     * @param model модель для передачи данных в представление
     * @return представление для изменения данных
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Integer id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    /**
     * Получение данных об измененном пользователе с формы представления
     * @param user
     * @return перенаправление на страницу со списком пользователей
     */
    @PostMapping("user-update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
}
