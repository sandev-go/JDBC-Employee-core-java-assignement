package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil
{
	static {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection()
	{
		try {
			Connection con = DriverManager
					.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
