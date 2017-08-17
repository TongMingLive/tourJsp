package com.tour.sevlet;

import com.tour.bean.Friend;
import com.tour.dao.FriendDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by tong on 17-3-27.
 */
@WebServlet(name = "SelectFriendServlet",urlPatterns = "/SelectFriendServlet")
public class SelectFriendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        FriendDao dao = new FriendDao();
        List<Friend> list = dao.selectFriend();
        JSONArray jsonArray = JSONArray.fromObject(list);
        out.print(jsonArray.toString());

        out.flush();
        out.close();
    }
}
