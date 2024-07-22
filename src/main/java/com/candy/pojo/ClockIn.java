package com.candy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClockIn {
    private Integer id;
    private LocalDate date;
    private String part;
    private Integer partId;
    private LocalTime takeTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
