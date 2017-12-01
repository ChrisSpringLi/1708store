package cn.tedu.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.tedu.tstore.dao.UserDao;
import cn.tedu.tstore.dao.UserDaoImpl;
import cn.tedu.tstore.entity.User;

public class DaoTest {
	
	@Test
	public void testFindAll(){
		UserDao dao = new UserDaoImpl();
		List<User> list=dao.findAllUser();
		for (User user : list) {
			System.out.println(user); 
		}
	}
	
	@Test
	public void testSaveUser(){
		User user=new User(null,
				"Tom", "123", "110@tedu.cn",
				"110", new Date());
		System.out.println(user); 
		UserDao dao = new UserDaoImpl();
		dao.saveUser(user); 
		System.out.println(user); 
	}
	
	@Test
	public void testFindAllByPage(){
		int start = 5;
		int size = 6;
		
		UserDao dao = new UserDaoImpl();
		List<User> list=dao.findAllByPage(
				start, size);
		for (User user : list) {
			System.out.println(user);
		}
		
	}
}
















