package cn.dbdj1201.service.impl;

import cn.dbdj1201.dao.UserDao;
import cn.dbdj1201.dao.impl.UserDaoImpl;
import cn.dbdj1201.domain.PageBean;
import cn.dbdj1201.domain.User;
import cn.dbdj1201.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author tyz1201
 * @datetime 2020-02-18 13:59
 **/
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public int addUser(User user) {
        return dao.addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return dao.deleteUser(id);
    }

    @Override
    public int editUser(User user, int id) {
        return dao.editUser(user, id);
    }

    @Override
    public User findUserById(int id) {
        return dao.retrieveUser(id);
    }

    @Override
    public User login(User loginUser) {
        return dao.login(loginUser);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                dao.deleteUser(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currentPage <= 0) {
            currentPage = 1;
        }
        //1.创建空的PageBean对象
        PageBean<User> pb = new PageBean<>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setList(list);

        //5.计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }


}
