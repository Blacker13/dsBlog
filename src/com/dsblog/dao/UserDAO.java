package com.dsblog.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dsblog.entity.Blog;
import com.dsblog.entity.User;
public class UserDAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(User user) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction(); 
		session.save(user);
		tran.commit();
	//	session.getTransaction();	
		System.out.println("saved");
	}
	@SuppressWarnings("unchecked")
	public int login(User user){
		int flag = 0;
		List<User> list = null;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction(); 
		Query q = session.createQuery("from User where userName = ? and passwd = ?");
		q.setParameter(0, user.getUserName());
		q.setParameter(1, user.getPasswd());
		list = q.list();
		tran.commit();
		if(list != null && list.size()>0){
			flag = 1;
		}
		return flag;
	}
}
