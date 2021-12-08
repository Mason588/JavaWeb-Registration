package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryUser
 */
@WebServlet("/QueryUser")
public class QueryUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public QueryUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Connection con = null;
	  Statement stmt = null;
	  ResultSet rs = null;
	  request.setCharacterEncoding("big5");
	  response.setCharacterEncoding("big5");
	  response.setContentType("big5");
	  PrintWriter out =  response.getWriter();
	  out.println("<html><head></head><body>");
	  try {
		  Class.forName("com.mysql.jdbc.Driver");
		  con = DriverManager.getConnection("jdbc:mysql://localhost/aaa","root","rootroot");
		  stmt = con.createStatement();
		  rs = stmt.executeQuery("select * from user");
		  out.print("<table border ='1'>");
		  while(rs.next()) {
			  out.print("<tr>");
			  out.print("<td>"+rs.getInt("id"));
			  out.print("<td>"+rs.getString("name"));
			  out.print("<td>"+rs.getString("passwd"));
			  out.print("<td>"+rs.getString("email"));
			  out.print("<td>"+rs.getString("city"));
		  }
		  out.println("</table>");
	  } catch (Exception e) {
		  out.println(e);
	  } 
	  finally {
		  try {
			con.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
