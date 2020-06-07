package com.wxh.cloud.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StorageMapper {
    @Update("UPDATE t_storage SET num = num-1 WHERE id = 1")
    public void test();
}
