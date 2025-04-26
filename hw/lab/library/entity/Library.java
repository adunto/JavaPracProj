package lab.library.entity;

import java.util.*;

public class Library {
	private String name;
	private List<Book> books;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<Book>();
	}
	
	// ������ ���� �����ֱ�
	public void showLibraryInfo() {
		System.out.println("\n--- " + name + " ---");
		System.out.println("��ü ���� �� : " + books.size());
		System.out.println("���� ���� ���� �� : " + getAvailableBooksCount());
		System.out.println("���� ���� ���� �� : " + getBorrowedBooksCount());
		System.out.println();
	}
	
	// ������ ���� �����ֱ�
		public void showCurrentLibraryInfo() {
			System.out.println("\n������ ���� ����:");
			System.out.println("��ü ���� �� : " + books.size());
			System.out.println("���� ���� ���� �� : " + getAvailableBooksCount());
			System.out.println("���� ���� ���� �� : " + getBorrowedBooksCount());
			System.out.println();
		}
	
	// ������ �߰��ϴ� �޼���
	public void addBook(Book book) {
		books.add(book);
		System.out.println("������ �߰��Ǿ����ϴ�: " + book.getTitle());
	}
	
	public int findBookByTitle(String title) {
		for(int i=0; i<books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				return i;
			}
		}
		return -1;
	}
	
	public int findBookByAuthor(String author) {
		for(int i=0; i<books.size(); i++) {
			if (books.get(i).getAuthor().equals(author)) {
				return i;
			}
		}
		return -1;
	}
	
	public int findBookByISBN(String isbn) {
		for(int i=0; i<books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				return i;
			}
		}
		return -1;
	}
	
	public void checkOutBook(String isbn) {
		// ã�� å �ε���
		int idx = findBookByISBN(isbn);
		
		if (books.get(idx).checkOut()) {
			System.out.println("���� ���� ����!");
			System.out.println("����� ���� ����:");
			System.out.println(books.get(idx).toString());
		}
		else {
			System.out.println("���� ���� ���� : ���� ������");
		}
	}
	
	
	public void returnBook(String isbn) {
		int idx = findBookByISBN(isbn);
		
		if (books.get(idx).returnBook()) {
			System.out.println("���� �ݳ� ����!");
			System.out.println("�ݳ��� ���� ����:");
			System.out.println(books.get(idx).toString());
		}
		else {
			System.out.println("���� �ݳ� ����");
		}
	}
	
	public List<Book> getAvailableBooks() {
		List<Book> list = new ArrayList<>();
		for(Book b : books) {
			if (b.getIsAvailable()) {
				list.add(b);
			}
		}
		
		return list;
	}
	
	public List<Book> getAllBooks() {
		return books;
	}
	
	public int getTotalBooks() {
		return books.size();
	}
	
	public int getAvailableBooksCount() {
		int cnt = 0;
		for(Book b : books) {
			if (b.getIsAvailable()) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public int getBorrowedBooksCount() {
		int cnt = 0;
		for(Book b : books) {
			if (!b.getIsAvailable()) {
				cnt++;
			}
		}
		return cnt;
	}
}
