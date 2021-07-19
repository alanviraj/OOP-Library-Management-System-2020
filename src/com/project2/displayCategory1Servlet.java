package com.project2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginPack.Customer;
import loginPack.custDButil;

/**
 * Servlet implementation class displayCategory1Servlet
 */
@WebServlet("/displayCategory1Servlet")
public class displayCategory1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username= (String) session.getAttribute("uname");
		
		try {
			List<Customer> custDet = custDButil.getCustDetails(username);
	      	request.setAttribute("custDetail", custDet);
	      	
			List <Search> category1 = SearchDBUtil.displayCategory1();
			request.setAttribute("category1" , category1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("Category1.jsp");
		dis.forward(request , response);	

	}

}