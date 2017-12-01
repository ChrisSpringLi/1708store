package cn.tedu.tstore.dao;

import java.util.List;

import cn.tedu.tstore.entity.User;

public interface UserDao {
	
	/**
	 * 查询全部用户信息
	 * @return 包含全部用户信息的集合
	 */
	List<User> findAllUser();
	
	/**
	 * 将用户信息保存到数据库中
	 * user的ID是自动生成的.
	 * @param user 是用户信息
	 */
	void saveUser(User user);
	
	/**
	 * 查询一个页面的全部user信息
	 * @param start 起始行数
	 * @param size  页面大小
	 * @return 一个页面的数据
	 */
	List<User> findAllByPage(
			int start, int size);
}











