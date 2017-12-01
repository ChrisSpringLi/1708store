package cn.tedu.tstore.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 显示添加用户的界面 
 */
public class UserAddServlet 
	extends AbstractServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
		throws ServletException, IOException {
		
		String path="/WEB-INF/jsp/user/add.jsp";
		forward(request, response, path); 
	}
}





