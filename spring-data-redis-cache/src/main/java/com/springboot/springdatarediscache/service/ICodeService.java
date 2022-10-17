package com.springboot.springdatarediscache.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.springdatarediscache.entity.Code;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2022-10-17
 */
public interface ICodeService extends IService<Code> {

    /**
     * @author zdd
     * @createTime 2022/10/17 16:39
     * @desc value是缓存管理器的名字
     * @Param [code]
     * @return com.springboot.springdatarediscache.entity.Code
     */
    @Cacheable(value = "cacheManager",key = "#p0")
    Code getByCode(String code);

    @CachePut
    void addByCode(Code code);
}
