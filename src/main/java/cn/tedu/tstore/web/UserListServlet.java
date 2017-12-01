package cn.tedu.tstore.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.tstore.dao.UserDao;
import cn.tedu.tstore.dao.UserDaoImpl;
import cn.tedu.tstore.entity.User;
/**
 * 用户列表功能 
 */
public class UserListServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
		throws ServletException, IOException {
		UserDao dao = new UserDaoImpl();
		List<User> list=dao.findAllUser();
		
		//转发到 JSP 显示用户列表
		//传递数据:
		request.setAttribute("users", list);
		//转发到目标页面
		String path="/WEB-INF/jsp/user/list.jsp";
		RequestDispatcher rd=
			request.getRequestDispatcher(path);
		rd.forward(request, response); 
	}

}



