package com.Db_connect.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db_connect.model.DAOService;
import com.Db_connect.model.DAOServiceimpl;

@WebServlet("/getRegistrations")
public class GetRegistrations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetRegistrations() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DAOService service = new DAOServiceimpl();
		service.connect_Db();
		
		ResultSet result = service.listAllReg();
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/search_result.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
