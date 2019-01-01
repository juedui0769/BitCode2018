package com.wxg.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

/**
 * 2018年12月31日12:43:07
 * HikariC : https://github.com/brettwooldridge/HikariCP#initialization
 */
public class HikariCPUtils {

    public static DataSource dsWithUrlUsernamePwd(String url, String username, String password) {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource hikariDataSource = new HikariDataSource(config);

        return hikariDataSource;
    }

}
