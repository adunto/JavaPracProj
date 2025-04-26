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
	
	// ���� ������ ó���ϴ� �޼���
	public boolean checkOut() {
		if (isAvailable) {
			this.isAvailable = false;
			return true;
		}
		else {
			return false;
		}
	}
	
	// ���� �ݳ��� ó���ϴ� �޼���
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
		String result = "\t���� ���� ����:" + (isAvailable ? "����" : "�Ұ���");
		return "å ����:" + title +
				"\t����:" + author +
				"\tISBN:" + isbn +
				"\t���ǳ⵵:" + publishYear +
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
