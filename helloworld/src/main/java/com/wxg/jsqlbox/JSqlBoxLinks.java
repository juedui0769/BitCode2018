package com.wxg.jsqlbox;

import com.github.drinkjava2.jdialects.Dialect;
import com.github.drinkjava2.jdialects.TableModelUtils;
import com.github.drinkjava2.jsqlbox.SqlBoxContext;
import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;

/**
 *
 * {@link com.github.drinkjava2.jdialects.model.TableModel}
 */
public class JSqlBoxLinks {

    public JSqlBoxLinks() {
        ds = JdbcConnectionPool
                .create("jdbc:h2:mem:DBName;MODE=MYSQL;DB_CLOSE_DELAY=-1;TRACE_LEVEL_SYSTEM_OUT=0",
                        "sa", "");
        ctx = new SqlBoxContext(ds);
        SqlBoxContext.setGlobalSqlBoxContext(ctx);
        ctx.setAllowShowSQL(true);
    }

    /**
     * from : https://gitee.com/drinkjava2/jSqlBox/wikis/pages?sort_id=230651
     *
     * {@link com.github.drinkjava2.jdialects.model.TableModel}
     * {@link Dialect}
     */
    public void know_Dialect() {
        Dialect dialect = ctx.getDialect();

        String[] ddls = ctx.toCreateDDL(JSqlBoxLinks.class);
        // 以上 `ctx.toCreateDDL` 等同于 `ctx.getDialect().toCreateDDL`
        ctx.getDialect().toCreateDDL(JSqlBoxLinks.class);

//        ctx.toDropDDL(JSqlBoxLinks.class);
//        ctx.toDropAndCreateDDL(JSqlBoxLinks.class);

    }

    /**
     * from : https://gitee.com/drinkjava2/jSqlBox/wikis/pages?sort_id=230651
     * {@link TableModelUtils}
     */
    public void know_TableModelUtils() {
        /**
         * 其中第一个参数为JDBC数据源，
         * 第二个参数为方言类型，
         * 第三个参数指示是否生成链式setter，
         * 第四个参数指示是否让实体类继承于jSqlBox的ActiveRecord类（否则就生成一个纯POJO),
         * 第五个参数为java包名，
         * 第6个参数为输出目录，例如"C:/java_entity/output"。
         */
        TableModelUtils.db2JavaSrcFiles(ds, ctx.getDialect(),
                false, false,
                "com.wxg.domain", "F:/wxgtest/55");
    }







    private DataSource ds;
    private SqlBoxContext ctx;

    private String name;
    private String age;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
