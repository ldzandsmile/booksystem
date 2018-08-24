package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public interface DaoInterface {
	/*
	 * 获得一个连接
	 */
	public Connection getConnection();
	
	/*
	 * 关闭连接
	 */
	public void close(Connection conn, PreparedStatement pstat, Statement stat);
	
	/*
	 * 增加数据
	 */
	public void insert();
	
	/*
	 * 删除
	 */
	public void delete();
	
	/*
	 * 修改
	 */
	public void update();
	
	/*
	 * 模糊查询
	 */
	public List selectLike();
	
	/*
	 * 排序
	 */
	public List order();
	
	/*
	 * 查询全部
	 */
	public List selectAll();
	
}

