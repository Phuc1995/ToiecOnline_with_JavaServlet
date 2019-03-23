package vn.myclass.core.web.utils;

import vn.myclass.core.daoimpl.ListenGuildelineDaoImpl;
import vn.myclass.core.daoimpl.RoleDaoImpl;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.service.impl.ListenGuidelineServiceImpl;
import vn.myclass.core.service.impl.RoleServiceImpl;
import vn.myclass.core.service.impl.UserServiceImpl;

public class SingletonServiceUtil {
    private static UserServiceImpl userServiceImpl = null;
    private static RoleServiceImpl roleServiceImpl = null;
    private static ListenGuidelineServiceImpl listenGuildelineServiceImpl = null;

    public static UserServiceImpl getUserServiceImplInstance(){
        if(userServiceImpl == null){
            userServiceImpl = new UserServiceImpl();
        }
        return userServiceImpl;
    }

    public static RoleServiceImpl getRoleServiceImplInstance(){
        if(roleServiceImpl == null){
            roleServiceImpl = new RoleServiceImpl();
        }
        return roleServiceImpl;
    }

    public static ListenGuidelineServiceImpl getListenGuildelineServiceImplInstance(){
        if(listenGuildelineServiceImpl == null){
            listenGuildelineServiceImpl = new ListenGuidelineServiceImpl();
        }
        return listenGuildelineServiceImpl;
    }
}
