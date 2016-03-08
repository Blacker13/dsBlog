package com.dsblog.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dsblog.dao.BlogDAO;
import com.dsblog.entity.Blog;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BlogDAOImp implements BlogDAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void add(Blog blog) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction(); 
		session.save(blog);
		tran.commit();
		//session.getTransaction();	
		System.out.println("Blog saved");
	}

	public void queryById(String id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<Blog> showAll() {
		// TODO Auto-generated method stub
		List<Blog> list = null;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction(); 
		Query q = session.createQuery("from Blog");
		list = q.list();
		tran.commit();
		return list;
	}

}
