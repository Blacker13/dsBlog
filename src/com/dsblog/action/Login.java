package com.dsblog.action;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dsblog.dao.UserDAO;
import com.dsblog.dao.imp.BlogDAOImp;
import com.dsblog.entity.Blog;
import com.dsblog.entity.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class Login implements Action {
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@SuppressWarnings("unchecked")
	public String login() throws Exception {
		System.out.println("------------------"+user.getUserName()+"   "+user.getPasswd());
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	    UserDAO userDAO = (UserDAO) context.getBean("userDao");
	   if(userDAO.login(user)==1){	 
	    BlogDAOImp blogDao =(BlogDAOImp)context.getBean("blogDao"); 
	    List<Blog> blogList = blogDao.showAll();
	    ActionContext.getContext().put("blogList", blogList);
	    Calendar ca = Calendar.getInstance(); 
	    String date = ""+(ca.get(Calendar.YEAR))+"-"+ca.get(Calendar.MONTH)+"-"+ca.get(Calendar.DAY_OF_MONTH);
	    ActionContext.getContext().put("date", date);
	    ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        session.put("userName", user.getUserName());
		return "success";
		}else{
		return "error";
		}
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		System.out.println("------------------"+user.getUserName()+"   "+user.getPasswd());
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	    UserDAO userDAO = (UserDAO) context.getBean("userDao");
	   if(userDAO.login(user)==1){	 
	    BlogDAOImp blogDao =(BlogDAOImp)context.getBean("blogDao"); 
	    List<Blog> blogList = blogDao.showAll();
	    ActionContext.getContext().put("blogList", blogList);
	    Calendar ca = Calendar.getInstance(); 
	    String date = ""+(ca.get(Calendar.YEAR))+"-"+ca.get(Calendar.MONTH)+"-"+ca.get(Calendar.DAY_OF_MONTH);
	    ActionContext.getContext().put("date", date);
	    ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        session.put("userName", user.getUserName());
		return "success";
		}else{
		return "error";
		}
	}
public String goIndex(){
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	BlogDAOImp blogDao =(BlogDAOImp)context.getBean("blogDao"); 
    List<Blog> blogList = blogDao.showAll();
    ActionContext.getContext().put("blogList", blogList);
    Calendar ca = Calendar.getInstance(); 
    String date = ""+(ca.get(Calendar.YEAR))+"-"+ca.get(Calendar.MONTH)+"-"+ca.get(Calendar.DAY_OF_MONTH);
    ActionContext.getContext().put("date", date);
	return "go";
}
}
