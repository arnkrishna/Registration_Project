package com.Db_connect.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db_connect.model.DAOService;
import com.Db_connect.model.DAOServiceimpl;


@WebServlet("/registrationcontroller")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RegistrationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/create_registration.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOService service =new DAOServiceimpl();
		
		service.connect_Db();
		
		service.saveRegistration( name,city ,email, mobile);
		request.setAttribute("msg", "Record Saved..!");

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/create_registration.jsp");
		rd.include(request, response);
		

	}

}
