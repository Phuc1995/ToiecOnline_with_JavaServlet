package vn.myclass.core.service.utils;

import vn.myclass.core.daoimpl.ListenGuildelineDaoImpl;
import vn.myclass.core.daoimpl.RoleDaoImpl;
import vn.myclass.core.daoimpl.UserDaoImpl;

public class SingletonDaoUtil {
    private static UserDaoImpl userDaoImpl = null;
    private static RoleDaoImpl roleDaoImpl = null;
    private static ListenGuildelineDaoImpl listenGuildelineDaoImpl = null;

    public static UserDaoImpl getUserDaoInstance(){
        if(userDaoImpl == null){
            userDaoImpl = new UserDaoImpl();
        }
        return userDaoImpl;
    }

    public static RoleDaoImpl getRoleDaoInstance(){
        if(roleDaoImpl == null){
            roleDaoImpl = new RoleDaoImpl();
        }
        return roleDaoImpl;
    }

    public static ListenGuildelineDaoImpl getlistenGuildelineDaoInstance(){
        if(listenGuildelineDaoImpl == null){
            listenGuildelineDaoImpl = new ListenGuildelineDaoImpl();
        }
        return listenGuildelineDaoImpl;
    }
}
