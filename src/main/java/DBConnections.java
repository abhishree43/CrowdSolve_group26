//// package com.civicissuereporting.util;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class DBConnection {
//	  private static String URL = "jdbc:mysql://localhost:3306/civic_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
//	    private static String USER = "civic_user";
//	    private static String PASS = "civic_pass";
//
//	    static {
//	        try {
//	            // try to load db.properties from classpath (if present)
//	            InputStream is = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
//	            if (is != null) {
//	                Properties p = new Properties();
//	                p.load(is);
//	                URL = p.getProperty("db.url", URL);
//	                USER = p.getProperty("db.user", USER);
//	                PASS = p.getProperty("db.pass", PASS);
//	                is.close();
//	            }
//
//	            // load JDBC driver (MySQL Connector/J 8)
//	            Class.forName("com.mysql.cj.jdbc.Driver");
//	        } catch (Exception e) {
//	            // print to server logs; in prod use a logger instead
//	            e.printStackTrace();
//	        }
//	    }
//
//	    public static Connection getConnection() throws SQLException {
//	        return DriverManager.getConnection(URL, USER, PASS);
//	    }
//}
