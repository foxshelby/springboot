package com.springboot.springdatarediscache.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.springdatarediscache.entity.Code;
import com.springboot.springdatarediscache.mapper.CodeMapper;
import com.springboot.springdatarediscache.service.ICodeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-10-17
 */
@Service
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements ICodeService {

    @Override
    public Code getByCode(String code) {
        QueryWrapper<Code> codeQueryWrapper = new QueryWrapper<>();
        codeQueryWrapper.eq("code",code);
        return this.getOne(codeQueryWrapper);
    }

    @Override
    public void addByCode(Code code) {
        this.save(code);
    }
}
