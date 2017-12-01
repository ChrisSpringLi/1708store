package cn.tedu.tstore.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.tstore.dao.UserDao;
import cn.tedu.tstore.dao.UserDaoImpl;
import cn.tedu.tstore.entity.User;

/**
 * 保存用户信息到 数据库  
 */
public class UserSaveServlet 
	extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
		throws ServletException, IOException {
		//获取用户提交非表单信息
		request.setCharacterEncoding("UTF-8");
		String username=
				request.getParameter("username");
		String password=
				request.getParameter("password");
		String confirm=
				request.getParameter("confirm");
		String email=
				request.getParameter("email");
		String mobile=
				request.getParameter("mobile");
		//检验表单信息
		String input="/WEB-INF/jsp/user/add.jsp";
		if(username==null || 
				username.trim().isEmpty()){
			request.setAttribute(
				"error","用户名不能空");
			forward(request, response, input);
			return;//不结束, 将出现异常!
		}
		String reg = "\\w{6,10}";
		if(! username.matches(reg)){
			request.setAttribute(
					"error","用户名6~10字符");
			forward(request, response, input);
			return;//不结束, 将出现异常!
		}
		
		//调用dao保存信息
		UserDao dao = new UserDaoImpl();
		User user= new User(null, username,
				password, email, mobile,
				new Date());
		dao.saveUser(user);
		//转发到成功页面
		//request.setAttribute("user", user);
		request.setAttribute("message", 
				"成功添加:"+user);
		//String path="/WEB-INF/jsp/ok.jsp";
		//forward(request, response, path);
		//302重定向到 /user/list.do
		//拼接绝对路径
		String path =request.getContextPath()
				+ "/user/list.do";
		response.sendRedirect(path);  
		//response.setStatus(302);
		//response.setHeader("Localtion", path);
	}
}




