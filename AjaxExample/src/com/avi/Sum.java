package com.avi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avi.enums.ErrorType;

@WebServlet("/sum")
public class Sum extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			String strNum1 = request.getParameter("num1");
			String strNum2 = request.getParameter("num2");

			int num1 = Integer.parseInt(strNum1);
			int num2 = Integer.parseInt(strNum2);

			int answer = num1 + num2;

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println("{"+"\"result\":"+answer+"}");
			
			//Thread.sleep(5000);

		}
		catch(Exception e){
			// The following line (System.out.println()...) is an example to a mistake.
			// The client is not exposed to the error, hence no indication that an errror has occured.

			// Writing like that on the server side, is an error :  
			System.out.println("This is an error");  

			// This is the right way to describe an error to the user, 
			// because we put data, which tells the client what has appened and why :
			response.setStatus(ErrorType.GENERAL_ERRROR.getHttpErrorCode());
			response.setHeader("errorId", String.valueOf(ErrorType.GENERAL_ERRROR.getInternalErrorCode()));

		}
	}
}
