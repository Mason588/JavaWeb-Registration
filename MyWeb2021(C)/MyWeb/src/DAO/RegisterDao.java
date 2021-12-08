package DAO;
import java.util.*;
import bean.User;
import java.sql.*;
public class RegisterDao {
	private static String tbName = "user";
	
	public static Connection getConncttion() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/aaa?useSSL=false&characterEncoding=utf8",
					"root","rootroot");
		} catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}
	
	//���J�ϥΪ̵��U�����
	public static int save(User u) {
		//�P�_��ƬO�_���J���\
		int status = 0;
		try {
			Connection conn = RegisterDao.getConncttion();
			String sql = "INSERT INTO " + tbName + "(name,passwd,email,city)values(?,?,?,?)";
			PreparedStatement  stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPasswd());
			stmt.setString(3, u.getEmail());
			stmt.setNString(4, u.getCity());
			status = stmt.executeUpdate();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
}
