package com.springboot.cache.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:zdd
 * @Date： 2022/11/15 14:40
 */
@Data
public class Cache implements Serializable {

    private String username;
    private String password;
}
