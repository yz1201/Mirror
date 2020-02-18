package cn.dbdj1201.dao.impl;

import cn.dbdj1201.dao.UserDao;
import cn.dbdj1201.domain.User;
import cn.dbdj1201.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author tyz1201
 * @datetime 2020-02-18 13:59
 **/
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * add user
     *
     * @param user table user
     * @return effect rows
     */
    public int addUser(User user) {
        int rows = template.update("insert into user(username, sex,age,address,qq_number,email) " +
                        "values(?,?,?,?,?,?)",
                user.getUsername(), user.getSex(), user.getAge(),
                user.getAddress(), user.getQq_number(), user.getEmail());

        return rows;
    }

    /**
     * @param id table user
     * @return effected rows
     */
    public int deleteUser(int id) {
        return template.update("delete from user where id = ?", id);
    }

    /**
     * @param user table
     * @return eff rows
     */
    @Override
    public int editUser(User user, int id) {
        return template.update("update user set username = ?, sex = ?, age = ?," +
                        " address = ?, qq_number = ?, email = ? where id = ?",
                user.getUsername(), user.getSex(), user.getAge(),
                user.getAddress(), user.getQq_number(), user.getEmail(), user.getId());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User retrieveUser(int id) {
        return template.queryForObject("select * from user where id = ?",
                new BeanPropertyRowMapper<>(User.class),
                id);
    }

    @Override
    public User login(User loginUser) {
        User user;
        try {
            user = template.queryForObject("select * from user where username = ? and password = ?",
                    new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
        } catch (DataAccessException e) {
            return null;
        }

        return user;
    }


    @Override
    public List<User> findAll() {
        return template.query("select * from user", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<>();
        for (String key : keySet) {

            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and ").append(key).append(" like ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);

        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }


    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user  where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }

        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params);

        return template.query(sql, new BeanPropertyRowMapper<>(User.class), params.toArray());
    }


}
