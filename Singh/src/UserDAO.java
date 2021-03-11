

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class UserDAO {



	public User checkLogin(String email, String password) throws SQLException, 
			ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection  con =DriverManager.getConnection("jdbc:mysql://localhost:3306/vaibhav1","root","root");
		Class.forName("com.mysql.jdbc.Driver");
		
		String sql = "SELECT * FROM user WHERE email = ? and password = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, password);

		ResultSet result = statement.executeQuery();

		User user = null;

		if (result.next()) {
			user = new User();
			user.setFullname(result.getString("fullname"));
			user.setEmail(email);
		}

		con.close();

		return user;
	}
}
