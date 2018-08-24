package model;

public class Borrow {
	private int borrow_id; // ���
	private int student_id; // ������ѧ�� ���
	private int book_id; // ������� ���
	private String borrow_date; // ����ʱ��
	private int borrow_managerid; // ����ʱ����Ա��� ���
	private String return_dateup; // �黹�������
	private String return_date; // �黹ʱ��
	private int return_managerid; // �黹ʱ����Ա��� ���

	private String book_name; // ���� ����borrow�����
	private String student_name; // ѧ������ ����borrow�����
	private int money; // ���� ����borrow�����
	private String borrow_managername;  //������ ����borrow�����
	
	public String getBorrow_managername() {
		return borrow_managername;
	}

	public void setBorrow_managername(String borrow_managername) {
		this.borrow_managername = borrow_managername;
	}

	public String getReturn_managername() {
		return return_managername;
	}

	public void setReturn_managername(String return_managername) {
		this.return_managername = return_managername;
	}

	private String return_managername;  //ǩ���� ����borrow�����

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Borrow(int borrow_id, int student_id, int book_id, String borrow_date, int borrow_managerid,
			String return_dateup, String return_date, int return_managerid) {
		this.borrow_id = borrow_id;
		this.student_id = student_id;
		this.book_id = book_id;
		this.borrow_date = borrow_date;
		this.borrow_managerid = borrow_managerid;
		this.return_dateup = return_dateup;
		this.return_date = return_date;
		this.return_managerid = return_managerid;
	}

	public Borrow(int student_id, int book_id, String borrow_date, int borrow_managerid, String return_dateup,
			String return_date, int return_managerid) {
		this.student_id = student_id;
		this.book_id = book_id;
		this.borrow_date = borrow_date;
		this.borrow_managerid = borrow_managerid;
		this.return_dateup = return_dateup;
		this.return_date = return_date;
		this.return_managerid = return_managerid;
	}

	public Borrow() {
	}

	public int getBorrow_id() {
		return borrow_id;
	}

	public void setBorrow_id(int borrow_id) {
		this.borrow_id = borrow_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}

	public int getBorrow_managerid() {
		return borrow_managerid;
	}

	public void setBorrow_managerid(int borrow_managerid) {
		this.borrow_managerid = borrow_managerid;
	}

	public String getReturn_dateup() {
		return return_dateup;
	}

	public void setReturn_dateup(String return_dateup) {
		this.return_dateup = return_dateup;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public int getReturn_managerid() {
		return return_managerid;
	}

	public void setReturn_managerid(int return_managerid) {
		this.return_managerid = return_managerid;
	}
}
