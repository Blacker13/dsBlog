package com.dsblog.action;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dsblog.dao.imp.BlogDAOImp;
import com.dsblog.entity.Blog;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class BlogService  implements Action, SessionAware{
	private Blog blog;
	
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public String add(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 BlogDAOImp blogDao =(BlogDAOImp)context.getBean("blogDao"); 
		 if(blog.getTitle()!=null && blog.getBlogContent()!=null){
		 blogDao.add(blog);
		 List<Blog> blogList = blogDao.showAll();
		    ActionContext.getContext().put("blogList", blogList);
		    Calendar ca = Calendar.getInstance(); 
		    String date = ""+(ca.get(Calendar.YEAR))+"-"+ca.get(Calendar.MONTH)+"-"+ca.get(Calendar.DAY_OF_MONTH);
		    ActionContext.getContext().put("date", date);
		return "success";
		}else{
			return "error";
		}
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
}
