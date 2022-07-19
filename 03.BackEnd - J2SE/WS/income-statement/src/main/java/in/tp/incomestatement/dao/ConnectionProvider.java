package in.tp.incomestatement.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {
	
	private static ConnectionProvider INSTANCE;
	
	private String dbUrl;
	private String dbUser;
	private String dbPassword;
	
	private ConnectionProvider() throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileReader("application.properties"));
		dbUrl = props.getProperty("database.url");
		dbUser = props.getProperty("database.user");
		dbPassword = props.getProperty("database.password");
	}
	
	public static ConnectionProvider getInstance() throws FileNotFoundException, IOException {
		if(INSTANCE==null) {
			INSTANCE=new ConnectionProvider();
		}
		return INSTANCE;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl,dbUser,dbPassword);
	}
}
