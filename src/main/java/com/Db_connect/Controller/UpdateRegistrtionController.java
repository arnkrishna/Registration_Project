package com.Db_connect.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Db_connect.model.DAOService;
import com.Db_connect.model.DAOServiceimpl;

/**
 * Servlet implementation class UpdateRegistrtionController
 */
@WebServlet("/update")
public class UpdateRegistrtionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateRegistrtionController() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		request.setAttribute("email", email);

		request.setAttribute("mobile", mobile);

		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/views/update_Registration.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		DAOService service = new DAOServiceimpl();

		service.connect_Db();
		service.updateRegistration(email,mobile);
		ResultSet result = service.listAllReg();

		request.setAttribute("result", result);
		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/views/search_result.jsp");
		rd.forward(request, response);

	}

}
