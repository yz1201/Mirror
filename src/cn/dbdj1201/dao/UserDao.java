package cn.dbdj1201.dao;

import cn.dbdj1201.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author tyz1201
 * @datetime 2020-02-18 13:56
 * JDBC操作数据库用户表
 **/
public interface UserDao {

    List<User> findAll();

    /**
     * @param user 要添加的用户
     * @return eff rows according to this to judge success or not
     */
    int addUser(User user);

    /**
     * 删除用户 by id
     *
     * @param id
     * @return 影响行数
     */
    int deleteUser(int id);

    /**
     * 编辑用户
     *
     * @param id
     * @param user
     * @return 影响行数
     */
    int editUser(User user, int id);

    User retrieveUser(int id);

    User login(User loginUser);

    /**
     * 查询总记录数
     *
     * @param condition
     * @return
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     *
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);

}
