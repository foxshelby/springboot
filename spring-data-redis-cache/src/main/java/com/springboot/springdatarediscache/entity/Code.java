package com.springboot.springdatarediscache.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2022-10-17
 */
@TableName("oauth_code")
@Data
public class Code implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String authentication;

}
