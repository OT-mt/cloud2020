package com.wxh.springcloud;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class ExceptionHandler {
    public static String handler1(BlockException e){
        return "hanlder1";
    }
    public static String handler2(){
        return "hanlder2";
    }
}
