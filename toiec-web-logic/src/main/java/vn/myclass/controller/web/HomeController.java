package vn.myclass.controller.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home.html")
public class HomeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/admin.jsp");
        rd.forward(request, response);

    }
    //hide url
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException{

    }
}
