package com.ss.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.dto.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}
	
	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>\r\n")
		  .append("<html>\r\n")
		  .append("		<head>\r\n")
		  .append("			<title>Form input</title>\r\n")
		  .append("		</head>\r\n")
		  .append("		<body>\r\n")
		  .append("			<form action=\"login\" method=\"POST\">\r\n")
		  .append("				Enter your username: \r\n")
		  .append("				<input type=\"text\" name=\"user\" />\r\n")
		  .append("				Password: \r\n")
		  .append("				<input type=\"text\" name=\"password\" />\r\n")
		  .append("				<input type=\"submit\" value=\"Submit\" />\r\n")
		  .append("			</form>\r\n")
		  .append("		</body>\r\n")
		  .append("</html>\r\n");

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		HashMap<String, User> users = new HashMap<>();
		
		users.put("trevorhuis", new User(1, "trevorhuis", "Trevor Huis in 't Veld", "texas"));
		users.put("bradpitt", new User(2,"bradpitt", "Brad Pitt", "fightclub"));
		users.put("alpacino", new User(3,"alpacino", "Al Pacino", "godfather"));
		users.put("natalieportman", new User(4,"natalieportman", "Natalie Portman", "starwars"));
		
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>\r\n")
		  .append("<html>\r\n")
		  .append("		<head>\r\n")
		  .append("			<title>Form input</title>\r\n")
		  .append("		</head>\r\n")
		  .append("		<body>\r\n");
		  if(users.containsKey(user)) {
			  if (users.get(user).getPassword().equals(password)) {
				  out.append("Welcome " + users.get(user).getRealName());
			  } else {
				  out.append("That is not the correct password for the user: " + user + "!");
			  }
		  } else {
			  out.append("That user is not in our database");
			  
		  }
		  
		  out.append("		</body>\r\n")
		  .append("</html>\r\n");

	}
}
