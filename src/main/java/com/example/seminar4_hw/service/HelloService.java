package com.example.seminar4_hw.service;

import org.springframework.stereotype.Service;

/**
 * Класс, который представляет собой сервис, возвращающий приветственное сообщение
 */
@Service
public class HelloService {
    public String getGreeting() {
        return "Hello, world!";
    }
}
