package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public interface DaoInterface {
	/*
	 * ���һ������
	 */
	public Connection getConnection();
	
	/*
	 * �ر�����
	 */
	public void close(Connection conn, PreparedStatement pstat, Statement stat);
	
	/*
	 * ��������
	 */
	public void insert();
	
	/*
	 * ɾ��
	 */
	public void delete();
	
	/*
	 * �޸�
	 */
	public void update();
	
	/*
	 * ģ����ѯ
	 */
	public List selectLike();
	
	/*
	 * ����
	 */
	public List order();
	
	/*
	 * ��ѯȫ��
	 */
	public List selectAll();
	
}

