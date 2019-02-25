package com.wxg.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wxg.baidu.fanyi.info.BaiduTranslateResult;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 2019年2月25日18:41:30 ，update
 * https://www.cnblogs.com/cdf-opensource-007/p/7106018.html
 *      - 这个页面讲解了 fastjson 的常用操作
 *      - 看完基本够用了。
 *
 */
public class HelloFastjson {

    public static void main(String[] args) {
        HelloFastjson helloFastjson = new HelloFastjson();

//        helloFastjson.jsonToMap();
        helloFastjson.jsonToClass();
    }

    public void mapToJson() {
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

    public void jsonToMap() {
        String jsonStr = "{\"from\":\"en\",\"to\":\"zh\",\"trans_result\":[{\"src\":\"apple\",\"dst\":\"\\u82f9\\u679c\"}]}";
//        Object parse = JSON.parse(jsonStr);
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        System.out.println(jsonObject.get("from"));
        System.out.println(jsonObject.get("to"));
        JSONArray trans_result1 = jsonObject.getJSONArray("trans_result");
        int size = trans_result1.size();
        for (int i=0;i<size;i++){
            JSONObject jsonObject1 = trans_result1.getJSONObject(i);
            System.out.print(jsonObject1.get("src"));
            System.out.print(" , ");
            System.out.println(jsonObject1.get("dst"));
        }
    }

    public void jsonToClass() {
        String jsonStr = "{\"from\":\"en\",\"to\":\"zh\",\"trans_result\":[{\"src\":\"apple\",\"dst\":\"\\u82f9\\u679c\"}]}";
        BaiduTranslateResult result
                = JSON.parseObject(jsonStr, new TypeReference<BaiduTranslateResult>(){});
        System.out.println(result.getFrom());
        System.out.println(result.getTo());
        for (BaiduTranslateResult.TransResult ret : result.getTrans_result()) {
            System.out.println(ret.getSrc());
            System.out.println(ret.getDst());
        }
    }
}
