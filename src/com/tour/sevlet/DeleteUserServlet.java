package com.tour.sevlet;

import com.tour.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tong on 17-3-24.
 */
@WebServlet(name = "DeleteUserServlet", urlPatterns = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int userId = Integer.parseInt(request.getParameter("userId"));

        UserDao dao = new UserDao();
        int r = dao.deleteUser(userId);
        if (r > 0) {
            out.print("<script>alert('删除成功');location.href='allUser.jsp';</script>");
        } else {
            out.print("<script>alert('删除失败');location.href='allUser.jsp';</script>");
        }
    }
}
