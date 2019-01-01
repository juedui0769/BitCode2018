package com.wxg.jsqlbox;

import com.github.drinkjava2.jdialects.TableModelUtils;
import com.github.drinkjava2.jsqlbox.SqlBoxContext;
import com.wxg.datasource.HikariCPUtils;
import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.Test;

import javax.sql.DataSource;

import static org.junit.Assert.*;

public class JSqlBoxLinksTest {

    /**
     * h2:
     * "jdbc:h2:mem:DBName;MODE=MYSQL;DB_CLOSE_DELAY=-1;TRACE_LEVEL_SYSTEM_OUT=0", "sa", ""
     *
     * mysql:
     * jdbc:mysql://192.168.3.26:3306/openapi?allowMultiQueries=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;autoReconnect=true
     * root, root
     * jdbc:mysql://127.0.0.1:3306/openapi?useUnicode=true&amp;characterEncoding=utf-8&amp;useSSL=false
     */
    @Test
    public void db2Java_test() {

        String url = "jdbc:mysql://127.0.0.1:3306/openapi?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        DataSource ds = HikariCPUtils.dsWithUrlUsernamePwd(url, "root", "root");

        SqlBoxContext ctx = new SqlBoxContext(ds);
        SqlBoxContext.setGlobalSqlBoxContext(ctx);
        ctx.setAllowShowSQL(true);

        TableModelUtils.db2JavaSrcFiles(ds, ctx.getDialect(),
                false, false,
                "com.wxg.domain", "F:/wxgtest/55");
    }
}