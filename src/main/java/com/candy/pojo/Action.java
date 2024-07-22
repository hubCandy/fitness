package com.candy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action {
    private Integer id;
    private String action;
    private Integer partId;
    private String part;
    private String image;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
