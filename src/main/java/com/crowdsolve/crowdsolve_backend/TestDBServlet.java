//// package com.civicissuereporting.servlet;
//
//import java.io.IOException;
//import java.io.ObjectInputStream.GetField;
//import java.sql.Connection;
//
//import com.civicissuereporting.util.DBConnection;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/testdb")
//public class TestDBServlet extends HttpServlet{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/plain;charset=UTF-8");
//        try (Connection con = DBConnection.getConnection()) {
//            if (con != null && !con.isClosed()) {
//                resp.getWriter().println("DB connection OK");
//            } else {
//                resp.getWriter().println("DB connection returned null/closed");
//            }
//        } catch (Exception e) {
//            resp.getWriter().println("DB connection error: " + e.getMessage());
//            e.printStackTrace(resp.getWriter());
//        }
//    }
//}
