package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Book;
import model.Manager;

public class AdministratorsDao extends BaseDao {
	Manager m;
	Connection conn;

	public Manager getM() {
		return m;
	}

	public void setM(Manager m) {
		this.m = m;
	}

	public AdministratorsDao() {
		conn = this.getConnection();
	}

	public int select() {
		int manager_id = -1;
		String sql = "select * from manager where manager_name=? and manager_password=?";
		ResultSet rs;
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, m.getManager_name());
			pstat.setString(2, m.getManager_password());
			rs = pstat.executeQuery();
			if (rs.next()) {
				manager_id = rs.getInt("manager_id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manager_id;
	}

	@Override
	public List selectAll() {
		ArrayList<Manager> manageList = new ArrayList<Manager>();
		String sql = "select * from manager";
		int i = 1;
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				Manager m = new Manager(Integer.parseInt(rs.getString("manager_id")), rs.getString("manager_name"),
						rs.getString("manager_password"));
				manageList.add(m);
			}
			close(null, null, stat);
		} catch (Exception e) {
			
		}
		return manageList;
	}
	
	@Override
	public void insert() {
		String sql = "insert into manager (manager_name, manager_password) values (?, ?)";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, m.getManager_name());
			pstat.setString(2, m.getManager_password());
			pstat.executeUpdate();

			close(null, pstat, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete() {
		String sql = "delete from manager where manager_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, m.getManager_id());
			pstat.executeUpdate();
			close(null, pstat, null);
		} catch (Exception e) {
		}
	}
	
	@Override
	public void update() {
		String sql = "update manager set manager_name=?, manager_password=? where manager_id=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, m.getManager_name());
			pstat.setString(2, m.getManager_password());
			pstat.setInt(3, m.getManager_id());
			pstat.executeUpdate();
			close(null, pstat, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
