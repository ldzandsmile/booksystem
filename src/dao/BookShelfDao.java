package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.BookShelf;

public class BookShelfDao extends BaseDao {
	Connection conn;
	BookShelf bs;
	int page;
	int pagenumber = 10;

	public BookShelf getBs() {
		return bs;
	}

	public void setBs(BookShelf bs) {
		this.bs = bs;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public BookShelfDao() {
		conn = this.getConnection();
	}

	@Override
	public List selectLike() {
		List<BookShelf> bookShelfList = new ArrayList<BookShelf>();
		int i = 1;
		try {
			String sql = "select * from bookshelf where bookshelf_type like ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, "%" + bs.getBookshelf_type() + "%");
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				BookShelf bs = new BookShelf(rs.getInt("bookshelf_id"), rs.getString("bookshelf_type"));
				bookShelfList.add(bs);
			}

			close(null, pstat, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookShelfList;
	}

	@Override
	public List selectAll() {
		List<BookShelf> bookShelfList = new ArrayList<BookShelf>();
		String sql = "select * from bookshelf limit ?,?";
		int i = 1;
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, (page - 1) * pagenumber);
			pstat.setInt(2, pagenumber);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				BookShelf bs = new BookShelf(rs.getInt("bookshelf_id"), rs.getString("bookshelf_type"));
				bookShelfList.add(bs);
			}
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bookShelfList;
	}

	@Override
	public void insert() {
		String sql = "insert into bookshelf (bookshelf_type) values (?)";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, bs.getBookshelf_type());
			pstat.executeUpdate();

			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		String sql = "delete from bookshelf where bookshelf_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, bs.getBookshelf_id());
			pstat.executeUpdate();
			close(null, pstat, null);
		} catch (Exception e) {
		}
	}

	@Override
	public void update() {
		String sql = "update bookshelf set bookshelf_type=? where bookshelf_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, bs.getBookshelf_type());
			pstat.setInt(2, bs.getBookshelf_id());
			pstat.executeUpdate();
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
