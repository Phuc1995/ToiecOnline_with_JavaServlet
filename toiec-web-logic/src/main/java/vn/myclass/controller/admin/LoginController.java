package vn.myclass.controller.admin;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import vn.myclass.command.UserCommand;
import vn.myclass.core.dto.CheckLogin;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.service.UserService;
import vn.myclass.core.service.impl.UserServiceImpl;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.SingletonServiceUtil;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(LoginController.class);
    File file = new File("E:\\Java_Servlet\\Toiec_Git_Clone\\Toiec\\version_5.0\\ToiecOnline_with_JavaServlet\\toiec-web\\src\\main\\resource");
    URL[] urls;

    {
        try {
            urls = new URL[]{file.toURI().toURL()};
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    ClassLoader loader = new URLClassLoader(urls);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("ResourcesBundle", Locale.getDefault(), loader);
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BasicConfigurator.configure();

//        log.error("jsp servlet myclass");
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class,request);
        UserDTO pojo = command.getPojo();
        if (pojo != null){
            CheckLogin login = SingletonServiceUtil.getUserServiceInstance().checkLogin(pojo.getName(), pojo.getPassword());
            if(login.getRoleName().equals(WebConstant.ROLE_ADMIN)){
                response.sendRedirect("/admin-home.html");
            }else if(login.getRoleName().equals(WebConstant.ROLE_USER)){
                response.sendRedirect("/home.html");
            }else {
                request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
                request.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.name.password.wrong"));
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
                rd.forward(request, response);
            }
        }
  /*      try{
            if(SingletonServiceUtil.getUserServiceImplInstance().isUserExit(pojo) != null){
                if(SingletonServiceUtil.getUserServiceImplInstance().findRoleByUser(pojo )!= null && SingletonServiceUtil.getUserServiceImplInstance().findRoleByUser(pojo).getRoleDTO() != null) {
                    if(SingletonServiceUtil.getUserServiceImplInstance().findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_ADMIN)){
                        response.sendRedirect("/admin-home.html");
                    }else if(SingletonServiceUtil.getUserServiceImplInstance().findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_USER)){
                        response.sendRedirect("/home.html");
                    }
                }

            }
        }catch(NullPointerException e){
            log.error(e.getMessage(),e);

        }*/

    }
}
