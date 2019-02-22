package vn.myclass.controller.admin;


import org.apache.commons.fileupload.FileUploadException;
import vn.myclass.command.ListenGuidelineCommand;
import vn.myclass.core.common.utils.UploadUtil;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.service.impl.ListenGuidelineServiceImpl;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.web.logic.common.WebConstant;

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
import java.util.Locale;
import java.util.ResourceBundle;

//@WebServlet("/admin-guideline-listen-list.html")
@WebServlet(urlPatterns = {"/admin-guideline-listen-list.html","/admin-guideline-listen-edit.html"})
public class ListenGuidelineController  extends HttpServlet {
    ListenGuidelineService guidelineService = new ListenGuidelineServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ListenGuidelineCommand command = FormUtil.populate(ListenGuidelineCommand.class, request);
        File file = new File("E:\\Java_Servlet\\Toiec_Git_Clone\\Toiec\\version_5.0\\ToiecOnline_with_JavaServlet\\toiec-web\\src\\main\\resource");
        URL[] urls = {file.toURI().toURL()};
        ClassLoader loader = new URLClassLoader(urls);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ResourcesBundle", Locale.getDefault(), loader);
/*        RequestUtil.initSearchBean(request, command);
        Object[] objects = guidelineService.findListenGuildelineByProperties(null,null,command.getSortExpression(),command.getSortDirection(),command.getFirstItem(),command.getMaxPageItems());
        command.setListResult((List<ListenGuidelineDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));*/
/*        request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
        request.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.guideline.listen.add.success"));*/
        request.setAttribute(WebConstant.LIST_ITEMS, command);
        if(command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)){
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
            rd.forward(request, response);
        }else if(command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)){
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/edit.jsp");
            rd.forward(request, response);
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UploadUtil uploadUtil = new UploadUtil();
        File file = new File("E:\\Java_Servlet\\Toiec_Git_Clone\\Toiec\\version_5.0\\ToiecOnline_with_JavaServlet\\toiec-web\\src\\main\\resource");
        URL[] urls = {file.toURI().toURL()};
        ClassLoader loader = new URLClassLoader(urls);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ResourcesBundle", Locale.getDefault(), loader);
        try {
            uploadUtil.writeOrUpdateFile(request);
            request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.guideline.listen.add.success"));
        } catch (FileUploadException e) {
            request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.error"));
        }catch (Exception e){
            request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.error"));
        }
        response.sendRedirect("/admin-guideline-listen-edit.html?urlType=url_edit");
    }
}
