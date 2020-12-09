package com.vti.presentationlayer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		deleteCookie(response,"uname");
		deleteCookie(response,"psw");
		deleteCookie(response,"role");
		deleteCookie(response,"fullname");
		//Home page
		response.sendRedirect(request.getContextPath());
	}

	private void deleteCookie(HttpServletResponse response, String key) {
		Cookie cookie = new Cookie(key,"");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
