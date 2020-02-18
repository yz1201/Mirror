package cn.dbdj1201.service;

import cn.dbdj1201.domain.PageBean;
import cn.dbdj1201.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author tyz1201
 * @datetime 2020-02-18 13:58
 **/
public interface UserService {

    /**
     * find all users
     *
     * @return
     */
    List<User> findAll();

    /**
     * @param user 要添加的用户
     * @return eff rows according to this to judge success or not
     */
    int addUser(User user);

    /**
     * 删除用户by id
     *
     * @param id
     * @return 影响行数
     */
    int deleteUser(int id);

    /**
     * 编辑用户
     *
     * @param user
     * @return 影响行数
     */
    int editUser(User user, int id);

    /**
     * find user by id
     *
     * @param id
     * @return
     */
    User findUserById(int id);

    User login(User loginUser);

    void delSelectedUser(String[] ids);

    PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition);

    User register(User user);

}
