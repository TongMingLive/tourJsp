package com.tour.sevlet;

import com.tour.bean.Messeng;
import com.tour.dao.MessengDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by tong on 17-3-28.
 */
@WebServlet(name = "UpdateHotelServlet",urlPatterns = "/UpdateHotelServlet")
public class UpdateHotelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int messengId = Integer.parseInt(request.getParameter("messengId"));

        MessengDao dao = new MessengDao();
        int r = dao.updateHotel(messengId);
        if (r>0){
            out.print("true");
        }else {
            out.print("false");
        }
    }
}
