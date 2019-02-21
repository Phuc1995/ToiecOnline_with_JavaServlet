package vn.myclass.core.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import vn.myclass.core.dao.ListenGuildeDao;
import vn.myclass.core.daoimpl.ListenGuildelineDaoImpl;

import java.util.HashMap;
import java.util.Map;

public class ListenGuildeTest {

    ListenGuildeDao listenGuildeDao;
    @BeforeTest
    public void initData(){
        listenGuildeDao = new ListenGuildelineDaoImpl();
    }

    @Test
    public void testFindByProperties(){
        ListenGuildeDao listenGuildeDao = new ListenGuildelineDaoImpl();
//        Object[] result = listenGuildeDao.findByProperty(null,null,null,null,0,2);

    }

    @Test
    public void checkApiFindbyproperty(){
        Map<String, Object> property = new HashMap<String, Object>();
        property.put("title", "Bai hd 8");
        property.put("content", "Noi dung bai hd 8");
        Object[] objects = listenGuildeDao.findByProperty(property,null,null,null,null);
    }
}
