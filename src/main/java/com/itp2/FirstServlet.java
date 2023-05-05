package com.itp2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.valves.CrawlerSessionManagerValve;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(description = "this is a servelet example", urlPatterns = { "/first"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("uname");
		String password = request.getParameter("upass");

		System.out.println("username = "+username+" , password = "+password);
		
		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		
		if(password.equals("pratu@27"))
		{
			PrintWriter pw = response.getWriter();
			pw.write("<!DOCTYPE html>");
			pw.write("<html>");
			pw.write("<h2 style=\"color:green;\">  Welcome to Home Page  </h2> ");
			pw.write("</html>");
		}
		else
		{
			RequestDispatcher dispacher = request.getRequestDispatcher("second");
			request.setAttribute("name", username);
			session.setAttribute("snam", username);
			context.setAttribute("cname",username);
			dispacher.forward(request, response);
		}
	}



}
