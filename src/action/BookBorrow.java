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

import dao.BookBorrowDao;
import model.Book;
import model.Borrow;
import model.Manager;

@WebServlet("/BookBorrow")
public class BookBorrow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookBorrowDao dao = new BookBorrowDao();

	public BookBorrow() {
	}

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
		} else if ("return".equals(method)) {
			returnBook(request, response);
			
			String result = select(request, response);

			response.setContentType("text/javascript; charset=utf-8");
			response.getWriter().print(result);
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

		ArrayList<Borrow> borrowList = new ArrayList<Borrow>();
		String result = null;

		if (selectName == null || "".equals(selectName)) {
			borrowList = (ArrayList<Borrow>) dao.selectAll();
		} else {
			Borrow b = new Borrow();
			ArrayList<Borrow> bList = new ArrayList<Borrow>();
			if ("书名".equals(selectType)) {
				b.setBook_name(selectName);
				ArrayList<Integer> book_idList = (ArrayList<Integer>) dao.selectBook_id(b.getBook_name());
				for(Integer i : book_idList){
					b.setBook_id(i);
					bList.add(b);
				}
			} else if ("姓名".equals(selectType)) {
				b.setStudent_name(selectName);
				ArrayList<Integer> student_idList = (ArrayList<Integer>) dao.selectStudent_idList(b.getStudent_name());
				for(Integer i : student_idList){
					b.setStudent_id(i);
					bList.add(b);
				}
			} else if ("借用时间".equals(selectType)) {
				b.setBorrow_date(selectName);
				bList.add(b);
			} else if ("归还时间".equals(selectType)) {
				b.setReturn_date(selectName);
				bList.add(b);
			} else if ("经手人".equals(selectType)) {
				b.setBorrow_managername(selectName);
				ArrayList<Integer> borrow_manageridList = (ArrayList<Integer>) dao.selectManager_idList(b.getBorrow_managername());
				for(Integer i : borrow_manageridList){
					b.setBorrow_managerid(i);
					bList.add(b);
				}
			} else if ("签收人".equals(selectType)) {
				b.setReturn_managername(selectName);
				ArrayList<Integer> return_manageridList = (ArrayList<Integer>) dao.selectManager_idList(b.getReturn_managername());
				for(Integer i : return_manageridList){
					b.setReturn_managerid(i);
					bList.add(b);
				}
			}
			
			for(Borrow bw : bList){
				dao.setB(bw);System.out.println(bw.getReturn_managerid());
				borrowList.addAll((ArrayList<Borrow>) dao.selectLike());
			}
		}

		for(Borrow bo : borrowList){
			bo.setStudent_name(dao.selectStudent_name(bo.getStudent_id()));
			bo.setBook_name(dao.selectBook_name(bo.getBook_id()));
			bo.setBorrow_managername(dao.selectManager_name(bo.getBorrow_managerid()));
			bo.setReturn_managername(dao.selectManager_name(bo.getReturn_managerid()));
			bo.setMoney(dao.selectMoney(bo.getBorrow_date()));
		}
		
		// 使用JackSon生成json对象
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(borrowList);
	}

	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Borrow b = new Borrow();
		b.setBook_id(Integer.parseInt(request.getParameter("book_id")));
		b.setStudent_id(Integer.parseInt(request.getParameter("student_id")));
		b.setBorrow_managerid(Integer.parseInt(request.getParameter("manager_id")));

		Date date = new Date();
		b.setBorrow_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date).toString());
		date.setMonth(date.getMonth() + 3);
		b.setReturn_dateup(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date).toString());
		dao.setB(b);

		int bookNumber = dao.selectBookNumber();
		int student_id = dao.selectStudent_id(b.getStudent_id());
		if (bookNumber > 0 && student_id != 0) {
			dao.insert();
			dao.updateBookNumber(bookNumber - 1);
		} else if (bookNumber < 1) {
			System.out.println("该书已被借完");
		} else if (student_id == 0) {
			System.out.println("查无此人");
		}
	}
	
	public void returnBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Borrow b = new Borrow();
		b.setBorrow_id(Integer.parseInt(request.getParameter("borrow_id")));
		b.setReturn_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString());
		b.setReturn_managerid(((Manager)request.getSession().getAttribute("manager")).getManager_id());
		
		dao.setB(b);
		dao.returnBook();
	}
}
