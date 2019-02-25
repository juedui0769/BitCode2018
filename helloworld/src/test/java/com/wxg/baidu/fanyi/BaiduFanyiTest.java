package com.wxg.baidu.fanyi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wxg.baidu.fanyi.info.BaiduTranslateResult;
import com.wxg.baidu.fanyi.info.SecretInfo;
import com.wxg.baidu.fanyi.util.FanyiLang;
import com.wxg.okhttp.util.ClientUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaiduFanyiTest {

    private BaiduFanyi baiduFanyi;

    public BaiduFanyiTest() {
        if(!BaiduFanyi.isInit()){
            String filepath = "D:\\wxg_test\\baidu\\SecretInfo.txt";
            BaiduFanyi.setSecretInfoStorePath(filepath);
        }
        baiduFanyi = BaiduFanyi.getInstance();
    }

    @BeforeClass
    public static void init() {}

    /**
     * 测试成功
     */
    @Test
    @Ignore
    public void invokeOfficial() {

        String query = "高度600米";

        String jsonResult = baiduFanyi.invokeOfficial(query, FanyiLang.EN);

        System.out.println(jsonResult);

        BaiduTranslateResult result
                = JSON.parseObject(jsonResult, new TypeReference<BaiduTranslateResult>(){});

        System.out.println(result);

    }

//    @Test
//    public void getIdAndSecretkeyFromLocalFile() {
//        BaiduFanyi baiduFanyi = new BaiduFanyi();
//        String filepath = "D:\\wxg_test\\baidu\\SecretInfo.txt";
//        SecretInfo secretInfo = baiduFanyi.getIdAndSecretkeyFromLocalFile(filepath);
//        System.out.println(secretInfo);
//    }

    @AfterClass
    public static void tearDown() {
        ClientUtils.destroy();
    }

    /**
     * 需要有 {@link #tearDown()} 来清理 okhttp client
     */
    @Test
    @Ignore
    public void invokeByOkhttp() {
        BaiduTranslateResult result = baiduFanyi.invokeByOkhttp("中国", FanyiLang.EN);
        System.out.println(result);

        result = baiduFanyi.invokeByOkhttp("pear", FanyiLang.ZH);
        System.out.println(result);
    }

}