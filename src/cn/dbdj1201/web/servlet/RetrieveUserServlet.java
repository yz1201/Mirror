package cn.dbdj1201.web.servlet;

import cn.dbdj1201.domain.User;
import cn.dbdj1201.service.UserService;
import cn.dbdj1201.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tyz1201
 * @datetime 2020-02-18 12:59
 **/
@WebServlet("/retrieveUser")
public class RetrieveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserService retriService = new UserServiceImpl();
        User user = retriService.findUserById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("select_user", user);
        if (user != null) {
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
