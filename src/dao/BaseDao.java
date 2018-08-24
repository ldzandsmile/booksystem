package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.spi.PassivationCapable;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BaseDao implements DaoInterface {
	String sql = null;
	ResultSet rs = null;

	@Override
	public Connection getConnection() {
		DataSource datasource = new ComboPooledDataSource("c3p0");
		Connection conn = null;
		try {
			conn = datasource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	@Override
	public void close(Connection conn, PreparedStatement pstat, Statement stat) {
		// TODO Auto-generated method stub
		try {
			if (conn != null) {
				conn.close();
			}
			if (pstat != null) {
				pstat.close();
			}
			if (stat != null) {
				stat.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List selectLike() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List order() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
