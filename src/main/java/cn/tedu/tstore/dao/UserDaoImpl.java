package cn.tedu.tstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.tedu.tstore.entity.User;
import cn.tedu.tstore.util.DBUtil;

public class UserDaoImpl
	implements UserDao{

	public List<User> findAllUser() {
		Connection conn=null;
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from user";
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			List<User> list=new ArrayList<User>();
			while(rs.next()){
				User user = mapRow(rs);
				list.add(user);
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			DBUtil.close(conn);
		}
	}
	private User mapRow(ResultSet rs) throws SQLException {
		User user=new User();
		user.setId(rs.getInt("id"));
		user.setUsername(
				rs.getString("username"));
		user.setPassword(
				rs.getString("password"));
		user.setEmail(
				rs.getString("email"));
		user.setMobile(
				rs.getString("mobile"));
		user.setCreateTime(
				rs.getTimestamp("create_time"));
		return user;
	}
	//UserDaoImpl
	public void saveUser(User user) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into user "
					+ "(id, username, "
					+ "password, email, "
					+ "mobile, create_time ) "
					+ "values (null,?,?,?,?,?)";
			PreparedStatement ps=
					conn.prepareStatement(sql,
					new String[]{"id"});
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getMobile());
			long l=user.getCreateTime().getTime();
			ps.setTimestamp(5,new Timestamp(l)); 
			//执行SQL
			int n = ps.executeUpdate();
			if(n!=1){
				throw new RuntimeException("保存失败");
			}
			//读取自动生成的ID
			//Generated 生成的 key:关键字id
			ResultSet rs=ps.getGeneratedKeys();
			while(rs.next()){
				user.setId(rs.getInt(1));  
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			DBUtil.close(conn); 
		}
	}
	
	
	public List<User> findAllByPage(int start, int size) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select id, username,"
					+ "password, email, "
					+ "mobile, create_time "
					+ "from user "
					+ "limit ?,? ";
			PreparedStatement ps=
					conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, size);
			ResultSet rs = ps.executeQuery();
			List<User> list=new ArrayList<User>();
			while(rs.next()){
				User user = mapRow(rs);
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			DBUtil.close(conn);
		}
	}
	
}
















