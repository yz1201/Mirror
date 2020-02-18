package cn.dbdj1201.web.servlet;

import cn.dbdj1201.dao.UserDao;
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
 * @datetime 2020-02-14 22:08
 **/
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User loginUser = new User();
        UserService loginService = new UserServiceImpl();
        String verificationCode_form = req.getParameter("verification_code");
        String verificationCode = (String) req.getSession().getAttribute("verification_code");
        req.getSession().removeAttribute("verification_code");
        boolean loginFlag = false;

        try {
            BeanUtils.populate(loginUser, req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("loginServlet-beanutils--->" + loginUser);

        User user = loginService.login(loginUser);
        System.out.println("loginServlet-->" + user + "--->verificationCode-->" + verificationCode + "-->veri_form-->" + verificationCode_form);
        if (verificationCode != null) {
            if (verificationCode.equalsIgnoreCase(verificationCode_form))
                loginFlag = true;
        }
        req.getSession().removeAttribute("verification_code");
        if (loginFlag) {
            //login success
            if (user != null) {
                req.getSession().setAttribute("user", user.getUsername());
                resp.sendRedirect(req.getContextPath() + "/welcome.jsp");
            } else {
                req.setAttribute("login_err", "用户名或者密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("check_err", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }


    }
}
