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
import dao.BookShelfDao;
import model.Book;
import model.BookShelf;
import model.Manager;

@WebServlet("/BookShelfManager")
public class BookShelfManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookShelfManager() {
	}

	BookShelfDao dao = new BookShelfDao();

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
		String selectName = request.getParameter("selectName");
		String selectType = request.getParameter("selectType");
		ArrayList<BookShelf> manageList;
		String result = null;
		
		int page = Integer.parseInt(request.getParameter("page"));
		dao.setPage(page);
		
		if (selectName == null || "".equals(selectName)) {
			manageList = (ArrayList<BookShelf>) dao.selectAll();
		} else {
			BookShelf bs = new BookShelf();
			dao.setBs(bs);
			if ("类别".equals(selectType)) {
				bs.setBookshelf_type(selectName);
			}

			manageList = (ArrayList<BookShelf>) dao.selectLike();
		}
		
		// 使用JackSon生成json对象
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(manageList);
	}

	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookShelf bs = new BookShelf(request.getParameter("bookshelf_type"));
		dao.setBs(bs);
		dao.insert();
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookShelf bs = new BookShelf();
		bs.setBookshelf_id(Integer.parseInt(request.getParameter("bookshelf_id")));
		dao.setBs(bs);
		dao.delete();
		response.sendRedirect("BookShelfMessage.jsp");
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookShelf bs = new BookShelf();
		bs.setBookshelf_id(Integer.parseInt(request.getParameter("bookshelf_id")));
		bs.setBookshelf_type(request.getParameter("bookshelf_type"));
		dao.setBs(bs);
		dao.update();
	}
}
