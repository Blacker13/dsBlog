package com.dsblog.dao;

import java.util.List;

import com.dsblog.entity.Blog;

public interface BlogDAO {
	public void add(Blog blog);
	public void queryById(String id);
	public void deleteById(String id);
	public List<Blog> showAll();
}
