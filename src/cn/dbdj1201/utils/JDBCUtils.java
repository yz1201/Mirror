package cn.dbdj1201.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

/**
 * @author tyz1201
 * @datetime 2020-02-14 16:40
 * druid-->jdbc utils
 **/
public class JDBCUtils {
    private static DataSource ds;

    static {
        Properties pro = new Properties();
        try {
            pro.load(Objects.requireNonNull(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties")));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return conn
     * @throws SQLException
     */
    public static Connection getCoon() throws SQLException {
        return ds.getConnection();
    }

    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * release source. connect pool collect connect
     *
     * @param conn
     * @param stmt
     */
    public static void close(Connection conn, Statement stmt) {
        close(null, conn, stmt);
    }

    public static void close(ResultSet rs, Connection conn, Statement stmt) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
