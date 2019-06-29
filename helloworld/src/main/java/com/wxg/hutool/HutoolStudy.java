package com.wxg.hutool;

import cn.hutool.Hutool;
import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * {@link Hutool}
 */
public class HutoolStudy {
    public static void main(String[] args) {
        System.out.println(Hutool.AUTHOR);

        uniqueId(); // 唯一ID
    }

    /**
     * {@link IdUtil}
     * <p>
     * https://www.hutool.cn/docs/#/core/%E5%B7%A5%E5%85%B7%E7%B1%BB/%E5%94%AF%E4%B8%80ID%E5%B7%A5%E5%85%B7-IdUtil?id=snowflake
     * </p><p>
     * https://www.hutool.cn/docs/#/core/工具类/唯一ID工具-IdUtil?id=snowflake
     * </p>
     */
    private static void uniqueId() {
        // UUID
        String uuid = IdUtil.randomUUID();
        System.out.println(uuid);
        String simpleUUID = IdUtil.simpleUUID();
        System.out.println(simpleUUID);

        // ObjectId
        String objectId = IdUtil.objectId();
        String nextObjectId = ObjectId.next();
        System.out.println(objectId);
        System.out.println(nextObjectId);

        // Snowflake
        Snowflake snowflake = IdUtil.createSnowflake(2, 3);
        long snowflakeId = snowflake.nextId();
        System.out.println(snowflakeId);
    }
}
