package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Book;
import model.Borrow;

public class BookBorrowDao extends BaseDao {
	Borrow b;
	Connection conn;
	int page;
	int pagenumber = 10;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Borrow getB() {
		return b;
	}

	public void setB(Borrow b) {
		this.b = b;
	}

	public BookBorrowDao() {
		conn = getConnection();
	}

	@Override
	public List selectLike() {
		List<Borrow> borrowList = new ArrayList<Borrow>();
		String sql = "";
		int i = 1;System.out.println(b.getBorrow_managerid());
		try {
			if (b.getBook_id() != 0) {
				sql = "select * from borrow where book_id = ? limit ?,?";
			} else if (b.getStudent_id() != 0) {
				sql = "select * from borrow where student_id = ? limit ?,?";
			} else if (b.getBorrow_date() != null && !"".equals(b.getBorrow_date())) {
				sql = "select * from borrow where borrow_date like ? limit ?,?";
			} else if (b.getReturn_date() != null && !"".equals(b.getReturn_date())) {
				sql = "select * from borrow where return_date like ? limit ?,?";
			} else if (b.getBorrow_managerid() != 0) {
				sql = "select * from borrow where borrow_managerid = ? limit ?,?";
			} else if (b.getReturn_managerid() != 0) {
				sql = "select * from borrow where return_managerid = ? limit ?,?";
			}

			PreparedStatement pstat = conn.prepareStatement(sql);

			if (b.getBook_id() != 0) {
				pstat.setInt(1, b.getBook_id());
			} else if (b.getStudent_id() != 0) {
				pstat.setInt(1, b.getStudent_id());
			} else if (b.getBorrow_date() != null && !"".equals(b.getBorrow_date())) {
				pstat.setString(1, "%" + b.getBorrow_date() + "%");
			} else if (b.getReturn_date() != null && !"".equals(b.getReturn_date())) {
				pstat.setString(1, "%" + b.getReturn_date() + "%");
			} else if (b.getBorrow_managerid() != 0) {
				pstat.setInt(1, b.getBorrow_managerid());
			} else if (b.getReturn_managerid() != 0) {
				pstat.setInt(1, b.getReturn_managerid());
			}
			
			pstat.setInt(2, (page-1)*pagenumber);
			pstat.setInt(3, pagenumber);
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				Borrow b = new Borrow();
				b.setBorrow_id(rs.getInt("borrow_id"));
				b.setBook_id(rs.getInt("book_id"));
				b.setStudent_id(rs.getInt("student_id"));
				b.setBorrow_date(rs.getString("borrow_date"));
				b.setBorrow_managerid(rs.getInt("borrow_managerid"));
				b.setReturn_dateup(rs.getString("return_dateup"));
				b.setReturn_date(rs.getString("return_date"));
				b.setReturn_managerid(rs.getInt("return_managerid"));
				borrowList.add(b);
			}

			close(null, pstat, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borrowList;
	}

	@Override
	public List selectAll() {
		List<Borrow> borrowList = new ArrayList<Borrow>();
		String sql = "select * from borrow limit ?,?";
		int i = 1;
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, (page-1)*pagenumber);
			pstat.setInt(2, pagenumber);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				Borrow b = new Borrow();
				b.setBorrow_id(rs.getInt("borrow_id"));
				b.setBook_id(rs.getInt("book_id"));
				b.setStudent_id(rs.getInt("student_id"));
				b.setBorrow_date(rs.getString("borrow_date"));
				b.setBorrow_managerid(rs.getInt("borrow_managerid"));
				b.setReturn_dateup(rs.getString("return_dateup"));
				String return_date = rs.getString("return_date");
				if(return_date != null)
					b.setReturn_date(return_date);
				else 
					b.setReturn_date("");
				b.setReturn_managerid(rs.getInt("return_managerid"));
				borrowList.add(b);
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return borrowList;
	}

	@Override
	public void insert() {
		String sql = "insert into borrow (student_id, book_id, borrow_date, borrow_managerid, return_dateup) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, b.getStudent_id());
			pstat.setInt(2, b.getBook_id());
			pstat.setString(3, b.getBorrow_date());
			pstat.setInt(4, b.getBorrow_managerid());
			pstat.setString(5, b.getReturn_dateup());
			pstat.executeUpdate();

			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int selectBookNumber(){
		String sql = "select book_number from book where book_id=?";
		int book_number = -1;
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, b.getBook_id());
			
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
				book_number = rs.getInt("book_number");
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book_number;
	}
	
	public void updateBookNumber(int bookNumber){
		String sql = "update book set book_number=? where book_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, bookNumber);
			pstat.setInt(2, b.getBook_id());
			
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Integer> selectStudent_idList(String student_name){
		ArrayList<Integer> student_idList = new ArrayList<Integer>();
		String sql = "select student_id from student where student_name like ?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, "%" + student_name + "%");
			
			ResultSet rs = pstat.executeQuery();
			if(rs.next()){
				student_idList.add(rs.getInt("student_id"));
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student_idList;
	}
	
	public int selectStudent_id(String student_name){
		int stunden_id = 0;
		String sql = "select student_id from student where student_name like ?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, student_name);
			
			ResultSet rs = pstat.executeQuery();
			if(rs.next()){
				stunden_id = rs.getInt("student_id");
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stunden_id;
	}
	
	public int selectStudent_id(int student_id){
		String sql = "select student_id from student where student_id = ?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, student_id);
			
			ResultSet rs = pstat.executeQuery();
			if(rs.next()){
				student_id = rs.getInt("student_id");
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student_id;
	}
	
	public String selectStudent_name(int student_id){
		String student_name = "";
		String sql = "select student_name from student where student_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, student_id);
			
			ResultSet rs = pstat.executeQuery();
			if(rs.next()){
				student_name = rs.getString("student_name");
			}else{
				student_name = "";
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student_name;
	}
	
	public String selectBook_name(int book_id){
		String book_name = "";
		String sql = "select book_name from book where book_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, book_id);
			
			ResultSet rs = pstat.executeQuery();
			if(rs.next()){
				book_name = rs.getString("book_name");
			}else{
				book_name = "";
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book_name;
	}
	
	public List<Integer> selectBook_id(String book_name){
		ArrayList<Integer> book_idList = new ArrayList<Integer>();
		String sql = "select book_id from book where book_name like ?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, "%" + book_name + "%");
			
			ResultSet rs = pstat.executeQuery();
			if(rs.next()){
				book_idList.add(rs.getInt("book_id"));
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book_idList;
	}
	
	public String selectManager_name(int manager_id){
		String manager_name = "";
		String sql = "select manager_name from manager where manager_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, manager_id);
			
			ResultSet rs = pstat.executeQuery();
			if(rs.next()){
				manager_name = rs.getString("manager_name");
			}else{
				manager_name = "";
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manager_name;
	}
	
	public int selectManager_id(String manager_name){
		int manager_id = 0;
		String sql = "select manager_id from manager where manager_name=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, manager_name);
			
			ResultSet rs = pstat.executeQuery();
			if(rs.next()){
				manager_id = rs.getInt("manager_id");
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manager_id;
	}
	
	public ArrayList<Integer> selectManager_idList(String manager_name){
		ArrayList<Integer> manager_idList = new ArrayList<Integer>();
		String sql = "select manager_id from manager where manager_name like ?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, "%" + manager_name + "%");
			
			ResultSet rs = pstat.executeQuery();
			if(rs.next()){
				manager_idList.add(rs.getInt("manager_id"));
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manager_idList;
	}
	
	public int selectMoney(String borrow_date){
		int money = 0;
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date borrow = dateFormat.parse(borrow_date);
			Date now = new Date();
			long from = borrow.getTime();
			long to = now.getTime();
			int days = (int) ((to - from)/(1000 * 60 * 60 * 24));
			
			if(days > 90){
				money = days-90;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return money;
	}
	
	public void returnBook(){
		String sql = "update borrow set return_date=?, return_managerid=? where borrow_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, b.getReturn_date());
			pstat.setInt(2, b.getReturn_managerid());
			pstat.setInt(3, b.getBorrow_id());
			
			pstat.executeUpdate();
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
