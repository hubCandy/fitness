package com.candy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detail {
    private Integer id;
    private Integer clockInId;
    private Integer actionId;
    private String action;
    private Integer classNum; //组数
    private Integer number; //每组数量
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
