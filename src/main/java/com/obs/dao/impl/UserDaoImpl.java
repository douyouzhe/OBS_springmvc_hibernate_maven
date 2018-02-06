package com.obs.dao.impl;

import com.obs.Entities.User;
import com.obs.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

//    @Override
//    public List listAllUsers() {
//        return sessionFactory.getCurrentSession().createQuery("from tb_USER").list();
//    }

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
        return (User) sessionFactory.getCurrentSession().get(User.class,userId);
    }
}
