package lab.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	public Book() {
		this.isAvailable = true;
	}
	
	public Book(String title, String author, String isbn, int publishYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
	}
	
	// 도서 대출을 처리하는 메서드
	public boolean checkOut() {
		if (isAvailable) {
			this.isAvailable = false;
			return true;
		}
		else {
			return false;
		}
	}
	
	// 도서 반납을 처리하는 메서드
	public boolean returnBook() {
		if (!isAvailable) {
			this.isAvailable = true;
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String result = "\t대출 가능 여부:" + (isAvailable ? "가능" : "불가능");
		return "책 제목:" + title +
				"\t저자:" + author +
				"\tISBN:" + isbn +
				"\t출판년도:" + publishYear +
				result;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}
	
	
}
