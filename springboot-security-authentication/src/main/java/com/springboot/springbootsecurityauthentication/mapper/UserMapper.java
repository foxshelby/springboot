package com.springboot.springbootsecurityauthentication.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.springbootsecurityauthentication.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2022-10-17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
