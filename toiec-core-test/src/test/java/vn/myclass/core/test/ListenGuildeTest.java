package vn.myclass.core.test;

import org.junit.Test;
import vn.myclass.core.dao.ListenGuildeDao;
import vn.myclass.core.daoimpl.ListenGuildelineDaoImpl;

public class ListenGuildeTest {
    @Test
    public void testFindByProperties(){
        ListenGuildeDao listenGuildeDao = new ListenGuildelineDaoImpl();
        Object[] result = listenGuildeDao.findByProperty(null,null,null,null,0,2);

    }

}
