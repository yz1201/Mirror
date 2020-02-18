package cn.dbdj1201.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author tyz1201
 * @datetime 2020-02-15 12:46
 **/
@WebServlet("/verificate")
public class VerificationCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.pink);
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.blue);
        graphics.drawRect(0, 0, width - 1, height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder verificationCode = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            String temp = String.valueOf(str.charAt(random.nextInt(str.length())));
            verificationCode.append(temp);
            graphics.drawString(temp, width / 5 * i, height / 2);
        }

        System.out.println("veriServlet-->" + verificationCode);

        //验证码用session保存， 跟表单提交的进行校验。
        HttpSession session = req.getSession();
        session.setAttribute("verification_code", verificationCode.toString());

        graphics.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            graphics.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }
}
