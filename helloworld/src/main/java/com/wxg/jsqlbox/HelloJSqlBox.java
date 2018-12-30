package com.wxg.jsqlbox;

import com.github.drinkjava2.jsqlbox.ActiveRecord;
import com.github.drinkjava2.jsqlbox.SqlBoxContext;
import org.h2.jdbcx.JdbcConnectionPool;

/**
 * 2018年12月30日23:05:17
 * from https://gitee.com/drinkjava2/jSqlBox/wikis/pages?sort_id=230670
 *
 * (1)
 * 如果工作在Java6、7环境下，pom中要引入jSqlBox的java6版，
 * `implements ActiveEntity`要改成`extends ActiveRecord`。
 *
 * (2)
 * 从2.0.4版起，`SqlBoxContextConfig`配置类不再使用
 */
public class HelloJSqlBox extends ActiveRecord<HelloJSqlBox> {

    public static void main(String[] args) {
        JdbcConnectionPool ds = JdbcConnectionPool
                .create("jdbc:h2:mem:DBName;MODE=MYSQL;DB_CLOSE_DELAY=-1;TRACE_LEVEL_SYSTEM_OUT=0",
                        "sa", "");
        SqlBoxContext ctx = new SqlBoxContext(ds);
        SqlBoxContext.setGlobalSqlBoxContext(ctx);
        ctx.setAllowShowSQL(true);
        String[] ddls = ctx.toCreateDDL(HelloJSqlBox.class);
        for (String ddl : ddls) {
            System.out.println(ddl);
            ctx.nExecute(ddl); // 建表
        }

        new HelloJSqlBox().putField("name", "Hello jSqlBox").insert();
        System.out.println(ctx.iQueryForString("select name from HelloJSqlBox"));
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
