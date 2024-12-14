package com.example.seminar4_hw.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.seminar4_hw.service.HelloService;

/**
 * Контроллер, который использует HelloService для получения и отображения приветственного сообщения
 */
@RestController //объединяет в себе аннотации @Controller и @ResponseBody. Это означает, что RestController
// не только помечает класс как Spring MVC Controller, но и автоматически
// преобразует возвращаемые контроллером данные в формат JSON или XML
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }
    @GetMapping("/")
    public String hello() {
        return helloService.getGreeting();
    }
}
