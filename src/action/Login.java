package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdministratorsDao;
import model.Manager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager m = new Manager(request.getParameter("username"), request.getParameter("password"));
		AdministratorsDao mdao = new AdministratorsDao();
		mdao.setM(m);
		int manager_id = mdao.select();
		if(manager_id != -1){
			m.setManager_id(manager_id);
			request.getSession().setAttribute("manager", m);
			response.sendRedirect("AdministratorsManager.jsp");
		}else if(manager_id == -1){
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
