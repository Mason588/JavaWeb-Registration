package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterDao;
import bean.User;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Register() {
        super();
        
    }


	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		response.setCharacterEncoding("big5");
		response.setContentType("text/html;charset=big5");
		request.setCharacterEncoding("big5");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		if(username == null) {
			username = "";
		}
		passwd = (passwd==null)?"" :passwd;
		email = (email==null)?"" :email;
		city = (city==null)?"" :city;
		
		//設置使用者資訊
		User user = new  User();
		user.setUsername(username);
		user.setPasswd(passwd);
		user.setEmail(email);
		user.setCity(city);
		
		int status = 0 ;
		try {
			status = RegisterDao.save(user);
				if(status>0) {
					out.print("恭喜!註冊成功!");
				} else {
					out.print("註冊未成功!");
				} 
			}catch (Exception e2) {
					System.out.println(e2);
				}
				out.close();
	}

}
