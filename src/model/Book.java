package model;

public class Book {
	private int book_id; // 书本编号
	private String book_name; // 书名
	private String book_author; // 作者
	private int book_number; // 剩余数量
	private String book_record; // 上架时间
	private int book_shelfid; // 书本位于书架的编号

	public Book(String book_name, String book_author, int book_number, String book_record, int book_shelfid) {
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_number = book_number;
		this.book_record = book_record;
		this.book_shelfid = book_shelfid;
	}

	public Book(int book_id, String book_name, String book_author, int book_number, String book_record,
			int book_shelfid) {
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_number = book_number;
		this.book_record = book_record;
		this.book_shelfid = book_shelfid;
	}

	public Book() {}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public int getBook_number() {
		return book_number;
	}

	public void setBook_number(int book_number) {
		this.book_number = book_number;
	}

	public String getBook_record() {
		return book_record;
	}

	public void setBook_record(String book_record) {
		this.book_record = book_record;
	}

	public int getBook_shelfid() {
		return book_shelfid;
	}

	public void setBook_shelfid(int book_shelfid) {
		this.book_shelfid = book_shelfid;
	}
}
