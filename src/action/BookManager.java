package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.BookDao;
import model.Book;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class BookManager
 */
@WebServlet("/BookManager")
public class BookManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookManager() {
	}

	BookDao dao = new BookDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println(method);
		if ("select".equals(method)) {
			String result = select(request, response);
			
			response.setContentType("text/javascript; charset=utf-8");
			response.getWriter().print(result);
		}else if ("insert".equals(method)) {
			insert(request, response);
		}else if ("delete".equals(method)) {
			delete(request, response);
		}else if ("update".equals(method)) {
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
		int page = Integer.parseInt(request.getParameter("page"));
		dao.setPage(page);

		ArrayList<Book> bookList;
		String result = null;

		if (selectName == null || "".equals(selectName)) {
			bookList = (ArrayList<Book>) dao.selectAll();
		} else {
			Book b = new Book();
			dao.setB(b);
			if ("书名".equals(selectType)) {
				b.setBook_name(selectName);
			} else if ("作者".equals(selectType)) {
				b.setBook_author(selectName);
			} else if ("书架号".equals(selectType)) {
				b.setBook_shelfid(Integer.parseInt(selectName));
			}

			bookList = (ArrayList<Book>) dao.selectLike();
		}

		// 使用JackSon生成json对象
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(bookList);
	}

	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book b = new Book(request.getParameter("book_name"), request.getParameter("book_author"),
				Integer.parseInt(request.getParameter("book_number")),
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString(),
				Integer.parseInt(request.getParameter("book_shelfid")));
		dao.setB(b);
		dao.insert();
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book b = new Book();
		b.setBook_id(Integer.parseInt(request.getParameter("book_id")));
		dao.setB(b);
		dao.delete();
		response.sendRedirect("BookManager.jsp");
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book b = new Book();
		b.setBook_id(Integer.parseInt(request.getParameter("book_id")));
		b.setBook_name(request.getParameter("book_name"));
		b.setBook_author(request.getParameter("book_author"));
		b.setBook_number(Integer.parseInt(request.getParameter("book_number")));
		b.setBook_shelfid(Integer.parseInt(request.getParameter("book_shelfid")));
		
		dao.setB(b);
		dao.update();
	}
}
