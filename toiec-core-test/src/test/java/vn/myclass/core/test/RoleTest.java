package vn.myclass.core.test;

import org.testng.annotations.Test;
import vn.myclass.core.dao.RoleDao;
import vn.myclass.core.daoimpl.RoleDaoImpl;
import vn.myclass.core.persistence.entity.RoleEntity;

import java.util.ArrayList;
import java.util.List;

public class RoleTest {
    @Test
    public void checkFindAll() {
        RoleDao roleDao = new RoleDaoImpl();
        List<RoleEntity> list = roleDao.findAll();
    }

    @Test
    public void checkUpdateRole() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(1);
        entity.setName("USER_5");
        roleDao.update(entity);
    }

    @Test
    public void checkSaveRole() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(1);
        entity.setName("USER_1");
        RoleEntity entity2 = new RoleEntity();
        entity2.setRoleId(2);
        entity2.setName("USER_2");
        RoleEntity entity3 = new RoleEntity();
        entity3.setRoleId(7);
        entity3.setName("USER_7");
        roleDao.update(entity);
    }

    @Test
    public void checkFindById() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = roleDao.findById(1);
    }

    @Test
    public void checkFindByProperty() {
        String property = null;
        Object value = null;
        String sortExpression = null;
        String sortDirection = null;
        RoleDao roleDao = new RoleDaoImpl();
        Object[] entity = roleDao.findByProperty(property,value,sortExpression,sortDirection);

    }

    @Test
    public void checkDelete() {
       List<Integer> listId = new ArrayList<Integer>();
//       listId.add(1);
//       listId.add(2);
//       RoleDao roleDao = new RoleDaoImpl();
//       Integer count = roleDao.delete(listId);
    }
}
