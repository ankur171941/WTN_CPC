package com.company.applicant.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;


public class DBUtil {
public static Connection getConn()
{
	Connection con=null;
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ankur","Ankur@123");

	}
	catch (ClassNotFoundException| SQLException e)
	{
		e.printStackTrace();
	}

	return con;
}
}
