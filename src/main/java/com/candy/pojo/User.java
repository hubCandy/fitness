package com.candy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private Integer age;
    private String email;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String token;
}
