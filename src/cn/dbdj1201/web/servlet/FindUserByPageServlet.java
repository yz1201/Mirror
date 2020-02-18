package cn.dbdj1201.web.servlet;

import cn.dbdj1201.domain.PageBean;
import cn.dbdj1201.domain.User;
import cn.dbdj1201.service.UserService;
import cn.dbdj1201.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if (currentPage == null || "".equals(currentPage)) {

            currentPage = "1";
        }


        if (rows == null || "".equals(rows)) {
            rows = "10";
        }

        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();

//        System.out.println("find user servlet ---->" + condition);
        condition.forEach((key, values) -> System.out.println(key + "--->" + Arrays.toString(values)));

        //2.调用service查询
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage, rows, condition);

        //3.将PageBean存入request
        request.setAttribute("pb", pb);
        request.setAttribute("condition", condition);//将查询条件存入request
        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
