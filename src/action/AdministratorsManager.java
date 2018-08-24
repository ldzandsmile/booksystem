package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.AdministratorsDao;
import model.Manager;

@WebServlet("/AdministratorsManager")
public class AdministratorsManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdministratorsManager() {
	}

	AdministratorsDao dao = new AdministratorsDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println(method);
   		if ("select".equals(method)) {
			String result = select(request, response);

			response.setContentType("text/javascript; charset=utf-8");
			response.getWriter().print(result);
		} else if ("insert".equals(method)) {
			insert(request, response);
		} else if ("delete".equals(method)) {
			delete(request, response);
		} else if ("update".equals(method)) {
			update(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public String select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Manager> manageList;
		String result = null;

		manageList = (ArrayList<Manager>) dao.selectAll();
		// 使用JackSon生成json对象
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(manageList);
	}

	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager m = new Manager(request.getParameter("manager_name"), request.getParameter("manager_password"));
		dao.setM(m);
		dao.insert();
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager m = new Manager();
		m.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
		dao.setM(m);
		dao.delete();
		response.sendRedirect("AdministratorsManager.jsp");
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Manager m = new Manager();
		m.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
		m.setManager_name(request.getParameter("manager_name"));
		m.setManager_password(request.getParameter("manager_password"));
		dao.setM(m);
		dao.update();
	}
}
