package com.vti.presentationlayer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vti.businesslayer.IUserService;
import com.vti.businesslayer.UserService;
import com.vti.entiy.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
	public class LoginController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private IUserService userService;   
	
	public void init() throws ServletException {
		super.init();
		try {
		 userService = new UserService();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
				dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname =request.getParameter("uname");
		String psw =request.getParameter("psw");
		
		try {
			User user = userService.login(uname, psw);
			if (user != null) {
			addCookie(response, "uname", user.getUsername());
			addCookie(response, "psw", psw);	
		
			addCookie(response, "role", user.getRole());
			//Home page
			response.sendRedirect(request.getContextPath());
			}else {
				String messengeError = "Ten dang nhap hoac mat khau khong dung";
				request.setAttribute("uname", uname);
				request.setAttribute("messengeError", messengeError);
				
				// forward to  jsp/login.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
				dispatcher.forward(request, response);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addCookie(HttpServletResponse response,String key,String value) {
		Cookie cookie = new Cookie(key,value);
		response.addCookie(cookie);
	}
}
