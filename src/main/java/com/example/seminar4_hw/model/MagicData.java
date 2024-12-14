package com.example.seminar4_hw.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sql")
@Getter
@Setter
public class MagicData {
    private String findAll;
    private String save;
    private String update;
    private String delete;
    private String findById;
}
