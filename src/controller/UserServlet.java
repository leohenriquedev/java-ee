package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.dao.UserDAO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		
		switch(method) {
		
			case "insert": 
				doPost(request, response);
				break;
			case "update": 
				doPut(request, response);
				break;
				
			case "delete": 
				doDelete(request, response);
				break;
			default:
				break;
		}
		
		response.sendRedirect("index.jsp");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User u = new User();
		UserDAO uDAO = new UserDAO();
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		u.setName(name);
		u.setAge(Integer.parseInt(age));
		
		uDAO.insert(u);
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User u = new User();
		UserDAO uDAO = new UserDAO();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		u.setId(Integer.parseInt(id));
		u.setName(name);
		u.setAge(Integer.parseInt(age));
		
		uDAO.update(u);
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDAO uDAO = new UserDAO();
		
		String id = request.getParameter("id");
		uDAO.delete(Integer.parseInt(id));
		
	}


}
