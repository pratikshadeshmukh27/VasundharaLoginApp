package com.itp2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		ServletContext context = this.getServletContext();
		
		String username = (String) request.getAttribute("name");
		String usernamefromsession = (String) session.getAttribute("sname");
		String usernamefromcontext = (String) context.getAttribute("cname");
		
		PrintWriter pw = response.getWriter();
		pw.write("<!DOCTYPE html>");
		pw.write("<html>");
		pw.write("<h2 style=\"color:red;\">  Invalid password mr."+username+"!</h2> ");
		pw.write("<h2 style=\"color:red;\">  Invalid password mr."+usernamefromsession+"! </h2> ");
		pw.write("<h2 style=\"color:red;\">  Invalid password mr."+usernamefromcontext+"! </h2> ");
		pw.write("</html>");	
		}
}
