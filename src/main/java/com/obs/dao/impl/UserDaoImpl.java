package com.obs.dao.impl;

import com.obs.Entities.User;
import com.obs.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public boolean deleteUser(User user) {
        try {
            sessionFactory.getCurrentSession().delete(user);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean saveOrUpdateUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        return true;
    }

    @Override
    public User getUser(String userId) {
        return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @Override
    public User userLogin(String username, String pwd) {
        String sql = "SELECT * from tb_USER where username=:param1 and password=:param2";
        Query query = sessionFactory.createEntityManager().createNativeQuery(sql);
        query.setParameter("param1",username);
        query.setParameter("param2",pwd);
        User user = (User) query.getSingleResult();
        return user;
    }

}
