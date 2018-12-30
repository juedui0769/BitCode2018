package com.wxg.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class HelloFastjson {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("id", "103");
        map.put("name", "wxg");
        map.put("age", "35");

        String jsonString = JSON.toJSONString(map);
        /**
         * output:
         * {"name":"wxg","id":"103","age":"35"}
         */
        System.out.println(jsonString);
    }
}
