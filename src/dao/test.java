package dao;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import model.Book;
import model.Manager;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class test {
	Connection conn = null;
	// ����sql���ʹ��
	Statement stmt = null;
	// ����sql�������
	String sql = null;
	ResultSet rs = null;

	// ���幹�캯�������������������ݿ�
	public test() {
		try {
			// ���ݿ�����
			Class.forName("com.mysql.jdbc.Driver");

			// �������ݿ����ӵ�ַ
			String url = "jdbc:mysql://localhost:3306/booksystem";
			// �����û�������
			String username = "root";
			String password = "root";

			// ��������
			conn = (Connection) DriverManager.getConnection(url, username, password);
			stmt = (Statement) conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������ʧ��");
		}
	}

	@Test
	public void text() {
		/*try {
			sql = "insert into book values (5, ?, ?, 1, ?, 2)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "ss1");
			pstmt.setString(2, "ss2");
			pstmt.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			sql = "select book_name from book where book_name like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%" + "JSP" + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("book_name"));
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void text2() {
		/*ManagerDao dao = new ManagerDao(new Manager("smile", "105716874s3"));
		System.out.println(dao.select());*/
		BaseDao dao = new BaseDao();
		Connection conn = dao.getConnection();
		String sql = "select * from book where book_shelfid like ?";;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + 1 + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("book_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void text3(){
		try {
			 // �������ݿ����ӵ�ַ
			 String url = "jdbc:mysql://localhost:3306/booksystem";
			 // �����û�������
			 String username = "root";
			 String password = "root";
			 // ����sql�������
			 String sql = null;
			
			 // �������ݿ�
			 Connection conn = DriverManager.getConnection(url, username, password);
			 Statement stmt = conn.createStatement();
			
			 sql = "select * from book";
			 ResultSet rs = stmt.executeQuery(sql);
			 while (rs.next()) {
				 System.out.println(rs.getString("book_name"));
			 }
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void text4(){
		String sql = "delete from book where book_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, 6);
			pstat.executeUpdate();  
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void text5(){
		String sql = "update book set book_name=?, book_author=?, book_number=?, book_shelfid=? where book_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, "1");
			pstat.setString(2, "1");
			pstat.setInt(3, 1);
			pstat.setInt(4, 1);
			pstat.setInt(5, 26);
			pstat.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void text6(){
		//new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString()
		Date date = new Date();
		date.setHours(date.getHours() + 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
	}
	
	@Test
	public void text7(){
		String sql = "select * from borrow where borrow_id=?";
		String date = "";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, "1");
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()){
				date = rs.getString("borrow_date");
			}
			pstat.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = dateFormat.parse(date);
			Date d2 = new Date();
			long from = d.getTime();System.out.println(from);
			long to = d2.getTime();System.out.println(to);
			int days = (int) ((to - from)/(1000 * 60 * 60 * 24));
			System.out.println(days);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	 // �������ݿ�
//	 public void createDatabase() {
//	 try {
//	 // �������ݿ����ӵ�ַ
//	 String url = "jdbc:mysql://localhost:3306";
//	 // �����û�������
//	 String username = "root";
//	 String password = "root";
//	 // �������ݿ�����
//	 Connection conn = null;
//	 // ����sql���ʹ��
//	 Statement stmt = null;
//	 // ����sql�������
//	 String sql = null;
//	
//	 // �������ݿ�
//	 conn = (Connection) DriverManager.getConnection(url, username, password);
//	 stmt = (Statement) conn.createStatement();
//	
//	 // �������ݿ�
//	 sql = "create database user if not exists character set utf8";
//	 stmt.executeUpdate(sql);
//	 System.out.println("a");
//	 // ����մ��������ݿ�
//	 sql = "use user";
//	 stmt.executeUpdate(sql);
//	 // ������
//	 sql = "create table message" + "(" + " username varchar(20) unique," + "
//	 password varchar(30) unique"
//	 + ")";
//	 stmt.executeUpdate(sql);
//	
//	 // �ر����ݿ�����
//	 stmt.close();
//	 conn.close();
//	 } catch (SQLException e) {
//	 // TODO Auto-generated catch block
//	 e.printStackTrace();
//	 }
//	 }
	//
	// // �������ݿ�����
	// public void insertDatabase(massage m) {
	// try {
	// // �������ݿ����ӵ�ַ
	// String url = "jdbc:mysql://localhost:3306";
	// // �����û�������
	// String username = "root";
	// String password = "root";
	// // �������ݿ�����
	// Connection conn = null;
	// // ����sql���ʹ��
	// Statement stmt = null;
	// // ����sql�������
	// String sql = null;
	//
	// // �������ݿ�
	// conn = (Connection) DriverManager.getConnection(url, username, password);
	// stmt = (Statement) conn.createStatement();
	//
	// // �������ݿ�
	// sql = "use user";
	// stmt.executeUpdate(sql);
	// // �������ݿ�����
	// sql = "insert into message value ('" + m.getUsername() + "', '" +
	// m.getPassword() + "')";
	// stmt.executeUpdate(sql);
	//
	// // �ر����ݿ�����
	// stmt.close();
	// conn.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// // ��ѯ���ݿ�
	// public ArrayList<massage> selectDatabase() {
	// ArrayList<massage> al = new ArrayList<massage>();
	// ResultSet rs = null;
	// int i = 0;
	//
	// try {
	// // �������ݿ����ӵ�ַ
	// String url = "jdbc:mysql://localhost:3306";
	// // �����û�������
	// String username = "root";
	// String password = "root";
	// // �������ݿ�����
	// java.sql.Connection conn = null;
	// // ����sql���ʹ��
	// java.sql.Statement stmt = null;
	// // ����sql�������
	// String sql = null;
	//
	// // �������ݿ�
	// conn = DriverManager.getConnection(url, username, password);
	// stmt = conn.createStatement();
	//
	// // �������ݿ�
	// sql = "use user";
	// stmt.executeUpdate(sql);
	// // ��ѯ���ݿ�����
	// sql = "select * from message";
	// rs = stmt.executeQuery(sql);
	//
	// while (rs.next()) {
	// i++;
	// massage m = new massage();
	// m.setUsername(rs.getString("username"));
	// m.setPassword(rs.getString("password"));
	// al.add(m);
	// }
	//
	// // �ر����ݿ�����
	// stmt.close();
	// conn.close();
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// if (i == 0)
	// return null;
	// else
	// return al;
	// }
	//
	// // ɾ�����ݿ�
	// public void deleteDatabase(String name) {
	// ResultSet rs = null;
	//
	// try {
	// // �������ݿ����ӵ�ַ
	// String url = "jdbc:mysql://localhost:3306";
	// // �����û�������
	// String username = "root";
	// String password = "root";
	// // �������ݿ�����
	// java.sql.Connection conn = null;
	// // ����sql���ʹ��
	// java.sql.Statement stmt = null;
	// // ����sql�������
	// String sql = null;
	//
	// // �������ݿ�
	// conn = DriverManager.getConnection(url, username, password);
	// stmt = conn.createStatement();
	//
	// // �������ݿ�
	// sql = "use user";
	// stmt.executeUpdate(sql);
	// // ��ѯ���ݿ�����
	// sql = "select * from message";
	// rs = stmt.executeQuery(sql);
	//
	// while (rs.next()) {
	// username = rs.getString("username");
	// password = rs.getString("password");
	// if (username.equals(name)) {
	// sql = "delete from message where username='" + name + "'";
	// stmt.executeUpdate(sql);
	// }
	// }
	//
	// // �ر����ݿ�����
	// stmt.close();
	// conn.close();
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// // �������ݿ�
	// public void updateDatabase(String name, String word) {
	// ResultSet rs = null;
	//
	// try {
	// // �������ݿ����ӵ�ַ
	// String url = "jdbc:mysql://localhost:3306";
	// // �����û�������
	// String username = "root";
	// String password = "root";
	// // �������ݿ�����
	// java.sql.Connection conn = null;
	// // ����sql���ʹ��
	// java.sql.Statement stmt = null;
	// // ����sql�������
	// String sql = null;
	//
	// // �������ݿ�
	// conn = DriverManager.getConnection(url, username, password);
	// stmt = conn.createStatement();
	//
	// // �������ݿ�
	// sql = "use user";
	// stmt.executeUpdate(sql);
	// // ��ѯ���ݿ�����
	// sql = "select * from message";
	// rs = stmt.executeQuery(sql);
	//
	// while (rs.next()) {
	// username = rs.getString("username");
	// password = rs.getString("password");
	// if (username.equals(name)) {
	// sql = "update message set username='" + name + "', password = '" + word +
	// "'";
	// stmt.executeUpdate(sql);
	// }
	// }
	//
	// // �ر����ݿ�����
	// stmt.close();
	// conn.close();
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}
