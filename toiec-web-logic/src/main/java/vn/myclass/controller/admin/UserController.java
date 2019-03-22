package vn.myclass.controller.admin;

import org.apache.log4j.Logger;
import vn.myclass.command.UserCommand;
import vn.myclass.core.dto.RoleDTO;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.service.RoleService;
import vn.myclass.core.service.UserService;
import vn.myclass.core.service.impl.RoleServiceImpl;
import vn.myclass.core.service.impl.UserServiceImpl;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.WebCommonUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

@WebServlet(urlPatterns = {"/admin-user-list.html", "/ajax-admin-user-edit.html"})
public class UserController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    UserService userService = new UserServiceImpl();
    RoleService roleService = new RoleServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand  command = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = command.getPojo();
        File file = new File("E:\\Java_Servlet\\Toiec_Git_Clone\\Toiec\\version_5.0\\ToiecOnline_with_JavaServlet\\toiec-web\\src\\main\\resource");
        URL[] urls = {file.toURI().toURL()};
        ClassLoader loader = new URLClassLoader(urls);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ResourcesBundle", Locale.getDefault(), loader);
        if(command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)){
            Map<String, Object> mapProperty = new HashMap<String, Object>();
            Object[] objects = userService.findByProperty(mapProperty, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
            command.setMaxPageItems(7);
            command.setListResult((List<UserDTO>) objects[1]);
            command.setTotalItems(Integer.parseInt(objects[0].toString()));
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            if (command.getCrudaction() != null){
                Map<String, String> mapMessage =  buidMapRedirectMessage(resourceBundle);

                WebCommonUtil.addRedirectMessage(request, command.getCrudaction(), mapMessage);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/list.jsp");
            rd.forward(request, response);

        }else if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)){
             if (pojo != null && pojo.getUserId() != null){
                command.setPojo(userService.findById(pojo.getUserId()));
            }
            command.setRoles(roleService.findAll());
            request.setAttribute(WebConstant.FROM_ITEM, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp");
            rd.forward(request, response);
        }

     }

    private Map<String, String> buidMapRedirectMessage(ResourceBundle resourceBundle) {
        Map<String, String> mapMessage = new HashMap<String, String>();
        mapMessage.put(WebConstant.REDIRECT_INSERT, resourceBundle.getString("label.user.message.add.success"));
        mapMessage.put(WebConstant.REDIRECT_UPDATE, resourceBundle.getString("label.user.message.update.success"));
        mapMessage.put(WebConstant.REDIRECT_DELETE, resourceBundle.getString("label.user.message.detele.success"));
        mapMessage.put(WebConstant.REDIRECT_ERROR, resourceBundle.getString("label.error"));
        return mapMessage;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            UserCommand  command = FormUtil.populate(UserCommand.class, request);
            UserDTO pojo = command.getPojo();
            if (command.getUrlType().equals(WebConstant.URL_EDIT)){
                if (command.getCrudaction() != null && command.getCrudaction().equals(WebConstant.INSERT_UPDATE)){
                    RoleDTO roleDTO = new RoleDTO();
                    roleDTO.setRoleId(command.getRoleId());
                    pojo.setRoleDTO(roleDTO);
                    if(pojo != null && pojo.getUserId() != null){
                        //update user
                        userService.updateUser(pojo);
                        request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_UPDATE);
                    } else {
                        //save
                        userService.saveUser(pojo);
                        request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_INSERT);
                    }
                    //request.setAttribute(WebConstant.MESSAGE_RESPONSE, "insert_success");
                }
            }

        }catch (Exception e){
             log.error(e.getMessage());
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_ERROR);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp");
        rd.forward(request, response);

    }
}
