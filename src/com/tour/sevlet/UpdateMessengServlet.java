package com.tour.sevlet;

import com.tour.dao.MessengDao;

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
@WebServlet(name = "UpdateMessengServlet",urlPatterns = "/UpdateMessengServlet")
public class UpdateMessengServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int messengId = Integer.parseInt(request.getParameter("messengId"));
        String messengType = request.getParameter("messengType");
        String messengName = request.getParameter("messengName");
        String messengTitle = request.getParameter("messengTitle");
        String messengPage = request.getParameter("messengPage");
        String messengAddress = request.getParameter("messengAddress");
        int messengRoom = Integer.parseInt(request.getParameter("messengRoom"));

        MessengDao dao = new MessengDao();
        int r = dao.updateMesseng(messengId,messengName,messengTitle,messengPage,messengAddress,messengRoom);
        if (r>0){
            out.print("<script>alert('修改成功！');location.href='allMesseng.jsp?messengType="+messengType+"';</script>");
        }
        else{
            out.print("<script>alert('修改失败！');location.href='allMesseng.jsp?messengType="+messengType+"';</script>");
        }
    }
}
