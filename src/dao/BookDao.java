package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookDao extends BaseDao {
	Connection conn;
	Book b;
	int page;
	int pagenumber = 10;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Book getB() {
		return b;
	}

	public void setB(Book b) {
		this.b = b;
	}

	public BookDao() {
		conn = this.getConnection();
	}

	@Override
	public List selectLike() {
		List<Book> bookList = new ArrayList<Book>();
		String sql = "";
		int i = 1;
		try {
			if (b.getBook_name() != null && !"".equals(b.getBook_name())) {
				sql = "select * from book where book_name like ? limit ?,?";
			} else if (b.getBook_author() != null && !"".equals(b.getBook_author())) {
				sql = "select * from book where book_author like ? limit ?,?";
			} else if (b.getBook_shelfid() != 0) {
				sql = "select * from book where book_shelfid like ? limit ?,?";
			}

			PreparedStatement pstat = conn.prepareStatement(sql);

			if (b.getBook_name() != null && !"".equals(b.getBook_name())) {
				pstat.setString(1, "%" + b.getBook_name() + "%");
			} else if (b.getBook_author() != null && !"".equals(b.getBook_author())) {
				pstat.setString(1, "%" + b.getBook_author() + "%");
			} else if (b.getBook_shelfid() != 0) {
				pstat.setString(1, "%" + b.getBook_shelfid() + "%");
			}
			
			pstat.setInt(2, (page-1)*pagenumber);
			pstat.setInt(3, pagenumber);
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				Book b = new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getString("book_author"),
						rs.getInt("book_number"), rs.getString("book_record"), rs.getInt("book_shelfid"));
				bookList.add(b);
			}
			
			close(null, pstat, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public List selectAll() {
		List<Book> bookList = new ArrayList<Book>();
		String sql = "select * from book limit ?,?";
		int i = 1;
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, (page-1)*pagenumber);
			pstat.setInt(2, pagenumber);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				Book b = new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getString("book_author"),
						rs.getInt("book_number"), rs.getString("book_record"), rs.getInt("book_shelfid"));
				bookList.add(b);
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bookList;
	}

	@Override
	public void insert() {
		String sql = "insert into book (book_name, book_author, book_number, book_record, book_shelfid) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, b.getBook_name());
			pstat.setString(2, b.getBook_author());
			pstat.setInt(3, b.getBook_number());
			pstat.setString(4, b.getBook_record());
			pstat.setInt(5, b.getBook_shelfid());
			pstat.executeUpdate();

			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete() {
		String sql = "delete from book where book_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, b.getBook_id());
			pstat.executeUpdate();
			close(null, pstat, null);
		} catch (Exception e) {
		}
	}
	
	@Override
	public void update() {
		String sql = "update book set book_name=?, book_author=?, book_number=?, book_shelfid=? where book_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, b.getBook_name());
			pstat.setString(2, b.getBook_author());
			pstat.setInt(3, b.getBook_number());
			pstat.setInt(4, b.getBook_shelfid());
			pstat.setInt(5, b.getBook_id());
			pstat.executeUpdate();
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
