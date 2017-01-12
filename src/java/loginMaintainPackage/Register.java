/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginMaintainPackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        try{
        
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	//creating connection with the database 
          Connection  con=DriverManager.getConnection
                     ("jdbc:mysql:/sql7.freemysqlhosting.net/sql7153359","sql7153359","A2TA9dYmR2");

        PreparedStatement ps=con.prepareStatement
                  ("insert into sql7153359 values(?,?)");

        ps.setString(1, user);
        ps.setString(2, pass);
        int i=ps.executeUpdate();
        
          if(i>0)
          {
            out.println("Rejestracja udana!");
          }
        
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      }
  }