package com.springboot.springdataredis.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @Author:zdd
 * @Date： 2022/10/17 10:06
 */
@Data
public class User implements Serializable {
    String username;
    String password;
}
