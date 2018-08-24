package model;

public class BookShelf {
	private int bookshelf_id;
	private String bookshelf_type;
	
	public BookShelf(int bookshelf_id, String bookshelf_type) {
		this.bookshelf_id = bookshelf_id;
		this.bookshelf_type = bookshelf_type;
	}
	
	public BookShelf(String bookshelf_type) {
		this.bookshelf_type = bookshelf_type;
	}
	
	public BookShelf() {
	}
	
	public int getBookshelf_id() {
		return bookshelf_id;
	}
	public void setBookshelf_id(int bookshelf_id) {
		this.bookshelf_id = bookshelf_id;
	}
	public String getBookshelf_type() {
		return bookshelf_type;
	}
	public void setBookshelf_type(String bookshelf_type) {
		this.bookshelf_type = bookshelf_type;
	}
	
}
