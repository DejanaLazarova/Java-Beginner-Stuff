package com.seavus.hellowebworld;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.seavus.hellowebworld.calculatorclass.Calculator;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/calculate")
public class CalculatorWebServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Calculator calc = new Calculator();
	HttpSession session;
	ArrayList<String> history = new ArrayList<String>();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("CalculatorServlet.doGet");
		session = request.getSession();
		session.setAttribute("history", history);
		printMessage(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("CalculatorServlet.doPost");
		session = request.getSession();
		session.setAttribute("history", history);
		printMessage(request, response);
	}

	private void printMessage(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		final int num1 = Integer.parseInt(request.getParameter("num1"));
		final int num2 = Integer.parseInt(request.getParameter("num2"));
		final String operation = request.getParameter("operation");
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		switch (operation) {
		case "ADD":
			history.add(num1 + " + " + num2 + " = " + calc.add(num1, num2));
			response.getWriter().println("The sum is :" + calc.add(num1, num2));
			break;
		case "SUBSTRACT":
			history.add(num1 + " + " + num2 + " = " + calc.substract(num1, num2));
			response.getWriter().println("The substraction is :" + calc.substract(num1, num2));
			break;
		case "HISTORY":
			response.getWriter().println(session.getAttribute("history"));
			break;
		}
	}
}
