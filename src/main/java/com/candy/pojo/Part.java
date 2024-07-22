package com.candy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Part {
    private Integer id;
    private String part;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
