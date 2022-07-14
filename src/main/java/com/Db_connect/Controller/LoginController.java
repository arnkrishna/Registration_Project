package com.Db_connect.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Db_connect.model.DAOService;
import com.Db_connect.model.DAOServiceimpl;

@WebServlet("/verifylogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		DAOService dao = new DAOServiceimpl();
		dao.connect_Db();
		boolean status = dao.verifyCredentials(email, password);
		if(status== true) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/create_registration.jsp");
			rd.forward(request, response);
		}else {
			//it will print error msg in web page
			request.setAttribute("error", "invalid username/password");
			//it helps to dispatch the page
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			// it helps to redirect the same login page with an error msg and new page
			//rd.forward(request, response);
			//it remains same page and print msg
			rd.include(request, response);
		}
	}

}
