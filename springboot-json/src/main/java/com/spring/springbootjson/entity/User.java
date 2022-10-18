package com.spring.springbootjson.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author:zdd
 * @Date： 2022/10/18 11:24
 */
@Data
public class User implements Serializable {

    private String name;
    private LocalDateTime birth;
}
