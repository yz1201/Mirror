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
 * @datetime 2020-02-18 15:11
 **/
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = new User();
        String verificationCode_form = request.getParameter("verification_code");
        String verificationCode = (String) request.getSession().getAttribute("verification_code");
        request.getSession().removeAttribute("verification_code");
        UserService registerService = new UserServiceImpl();
        User newUser = registerService.register(user);
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        boolean checkFlag = false;
        if (verificationCode != null) {
            if (verificationCode.equalsIgnoreCase(verificationCode_form))
                checkFlag = true;
        }

        if (checkFlag) {
            if (newUser != null) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                request.setAttribute("register_err", "你前边有人");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("check_err", "验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
