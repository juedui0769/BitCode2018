package com.wxg.baidu.fanyi.info;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.wxg.baidu.fanyi.util.FanyiLang;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 2019年2月25日16:10:05
 *
 * http://api.fanyi.baidu.com/api/trans/product/apidoc
 * 签名是为了保证调用安全，使用MD5算法生成的一段字符串，生成的签名长度为 32位，签名中的英文字符均为小写格式
 * 为保证翻译质量，请将单次请求长度控制在 6000 bytes以内。（汉字约为2000个）
 *
 */
public class BaiduTranslateFields {

    // 请求翻译query
    private String q;

    // 翻译源语言
    private String from = FanyiLang.AUTO;

    // 译文语言
    private String to;

    // APP ID
    private String appid;

    // 申请的密码
    private transient String secretKey;

    // 随机数
    private String salt = String.valueOf(System.currentTimeMillis());

    // 签名 : appid+q+salt+密钥 的MD5值
    private String sign;

    /**
     * {@link com.google.common.hash.Hashing}
     *
     * {@link Hashing#md5()}
     *      * If you must interoperate with a system that requires MD5,
     *      * then use this method, despite its deprecation.
     *      * But if you can choose your hash function, avoid MD5, which is neither fast nor secure.
     *      * As of January 2017, we suggest:
     *      *
     *      * 如果您必须与需要MD5的系统进行交互操作，那么尽管该方法被弃用，还是要使用它。
     *      * 但是，如果您可以选择散列函数，请避免使用既不快速也不安全的MD5。
     *      * 截至2017年1月，我们建议：
     *
     * @return
     */
    public String md5Sign() {
        String md5Str = Hashing.md5().hashString(getSign(), Charsets.UTF_8).toString();
        return md5Str;
    }

    public String getSign() {
        if (sign == null) {
            buildSign();
        }
        return sign;
    }

    /**
     * 注意在生成签名拼接 appid+q+salt+密钥 字符串时，q不需要做URL encode，
     * 在生成签名之后，发送HTTP请求之前才需要对要发送的待翻译文本字段q做URL encode。
     *
     * @return
     */
    private void buildSign() {
        StringBuilder sbb = new StringBuilder();
        sbb.append(appid)
                .append(q)
                .append(salt)
                .append(secretKey);
        sign = sbb.toString();
    }

    /**
     * 只有`q`字段有可能需要`encode`，其他几个字段都是在'ASCII'范围内的。
     * @return
     */
    public String getEncodeQuery() {
        String encode = null;
        try {
            encode = URLEncoder.encode(q, Charsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    // === 构造方法

    public BaiduTranslateFields(String q, String to, SecretInfo secretInfo) {
        this(q, to, secretInfo.getAppId(), secretInfo.getSecretKey());
    }

    public BaiduTranslateFields(String q, String to, String appid, String secretKey) {
        this.q = q;
        this.to = to;
        this.appid = appid;
        this.secretKey = secretKey;
    }

    public BaiduTranslateFields(String q, String from, String to, SecretInfo secretInfo) {
        this(q, from, to, secretInfo.getAppId(), secretInfo.getSecretKey());
    }

    public BaiduTranslateFields(String q, String from, String to, String appid, String secretKey) {
        this.q = q;
        this.from = from;
        this.to = to;
        this.appid = appid;
        this.secretKey = secretKey;
    }

    public BaiduTranslateFields(String q, String from, String to, String appid, String secretKey, String salt) {
        this.q = q;
        this.from = from;
        this.to = to;
        this.appid = appid;
        this.secretKey = secretKey;
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "BaiduTranslateFields{" +
                "q='" + q + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
//                ", appid='" + appid + '\'' +
//                ", secretKey='" + secretKey + '\'' +
                ", salt='" + salt + '\'' +
                ", sign='" + getSign() + '\'' +
                '}';
    }
}
