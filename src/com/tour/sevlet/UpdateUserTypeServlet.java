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
@WebServlet(name = "UpdateUserTypeServlet",urlPatterns = "/UpdateUserTypeServlet")
public class UpdateUserTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int userId = Integer.parseInt(request.getParameter("userId"));
        int userType = Integer.parseInt(request.getParameter("userType"));
        UserDao dao = new UserDao();
        int r = dao.updateType(userType,userId);
        if (r>0){
            out.print("<script>alert('修改成功！');location.href='allUser.jsp';</script>");
        }
        else{
            out.print("<script>alert('修改失败！');location.href='allUser.jsp';</script>");
        }
    }
}
