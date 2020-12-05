package com.vti.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name =request.getParameter("name");
		String passsword =request.getParameter("password");
		
		if ("nguyenducmanh".equals(name) && "M123456".equals(passsword)) {
			/*
			 * RequestDispatcher requestDispatcher = request.getRequestDispatcher("home");
			 * requestDispatcher.forward(request, response);
			 */
			response.sendRedirect("http://localhost:8080/Java2/home");
		}else {
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.print("Xin loi ban nhap sai ten dang nhap hoac mat khau");
			
			  RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			  requestDispatcher.include(request, response);
			 
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
