package com.wxg.baidu.fanyi;

import com.wxg.baidu.fanyi.info.SecretInfo;
import com.wxg.baidu.fanyi.util.FanyiLang;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaiduFanyiTest {

    @BeforeClass
    public static void init() {}

    /**
     * 测试成功
     */
    @Test
    @Ignore
    public void invokeOfficial() {

        if(!BaiduFanyi.isInit()){
            String filepath = "D:\\wxg_test\\baidu\\SecretInfo.txt";
            BaiduFanyi.setSecretInfoStorePath(filepath);
        }
        BaiduFanyi baiduFanyi = BaiduFanyi.getInstance();

        String query = "高度600米";

        String result = baiduFanyi.invokeOfficial(query, FanyiLang.EN);

        System.out.println(result);

    }

//    @Test
//    public void getIdAndSecretkeyFromLocalFile() {
//        BaiduFanyi baiduFanyi = new BaiduFanyi();
//        String filepath = "D:\\wxg_test\\baidu\\SecretInfo.txt";
//        SecretInfo secretInfo = baiduFanyi.getIdAndSecretkeyFromLocalFile(filepath);
//        System.out.println(secretInfo);
//    }
}