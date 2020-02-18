package cn.dbdj1201.web.servlet;

import cn.dbdj1201.domain.User;
import cn.dbdj1201.service.UserService;
import cn.dbdj1201.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author tyz1201
 * @datetime 2020-02-17 17:33
 **/
@WebServlet("/userEdit")
public class UserEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserService editService = new UserServiceImpl();
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        editService.editUser(user, Integer.parseInt(request.getParameter("id")));
        response.sendRedirect(request.getContextPath() + "/userList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
