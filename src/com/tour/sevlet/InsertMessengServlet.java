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
 * Created by tong on 17-3-25.
 */
@WebServlet(name = "InsertMessengServlet",urlPatterns = "/InsertMessengServlet")
public class InsertMessengServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int messengType = Integer.parseInt(request.getParameter("messengType"));
        String messengName = request.getParameter("messengName");
        String messengTitle = request.getParameter("messengTitle");
        String messengPage = request.getParameter("messengPage");
        String messengAddress = request.getParameter("messengAddress");
        String messengRoom = request.getParameter("messengRoom");
        int room;
        if (messengRoom == null) {
            room = 0;
        }else {
            room = Integer.parseInt(messengRoom);
        }

        String url = request.getHeader("Referer");

        MessengDao dao = new MessengDao();
        int r = dao.insertMesseng(messengType,messengName,messengTitle,messengPage,messengAddress,room);
        if (r > 0) {
            out.print("<script>alert('发布成功');location.href='"+url+"';</script>");
        } else {
            out.print("<script>alert('发布失败');location.href='"+url+"';</script>");
        }
    }
}
