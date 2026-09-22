package com.atguigu.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tiger {

    private Integer tigerId;
    private String tigerName;
    private Integer tigerAge;
    private Double tigerSalary;

}