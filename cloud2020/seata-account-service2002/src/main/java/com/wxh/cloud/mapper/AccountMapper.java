package com.wxh.cloud.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    @Insert("insert into t_account values(null,'test',11)")
    public void test();
}
