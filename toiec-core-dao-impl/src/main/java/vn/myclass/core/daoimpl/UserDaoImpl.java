package vn.myclass.core.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.myclass.core.common.utils.HibernateUtil;
import vn.myclass.core.dao.RoleDao;
import vn.myclass.core.dao.UserDao;
import vn.myclass.core.data.daoimpl.AbstractDao;
import vn.myclass.core.persistence.entity.RoleEntity;
import vn.myclass.core.persistence.entity.UserEntity;

public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {
    public Object[] checkLogin(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean isUserExist = false;
        String roleName = null;
        try{
            //ue la tien to
            StringBuilder sql = new StringBuilder("FROM UserEntity ue WHERE ue.name= :name AND ue.password= :password ");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name", name);
            query.setParameter("password", password);
            if(query.list().size() > 0){
                isUserExist = true;
                UserEntity userEntity = (UserEntity) query.uniqueResult();
                roleName = userEntity.getRoleEntity().getName();
            }
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {

        }
        return new Object[]{isUserExist, roleName};
    }
}
