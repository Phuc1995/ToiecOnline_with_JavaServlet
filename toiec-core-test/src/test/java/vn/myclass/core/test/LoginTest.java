package vn.myclass.core.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.persistence.entity.UserEntity;

public class LoginTest {
    private final Logger log = Logger.getLogger(LoginTest.class);

    @Test
    public void checkIsUserExit(){
        UserDao userDao = new UserDaoImpl();
        String name = "admin2";
        String password = "123456";
        UserEntity entity = userDao.isUserExit(name,password);
        if(entity!=null){
            log.error("Sussess");
        }else {
            log.error("Fail");
        }
    }
}
