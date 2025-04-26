package lab.library.entity;

import java.util.*;

public class Library {
	private String name;
	private List<Book> books;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<Book>();
	}
	
	// 도서관 정보 보여주기
	public void showLibraryInfo() {
		System.out.println("\n--- " + name + " ---");
		System.out.println("전체 도서 수 : " + books.size());
		System.out.println("대출 가능 도서 수 : " + getAvailableBooksCount());
		System.out.println("대출 중인 도서 수 : " + getBorrowedBooksCount());
		System.out.println();
	}
	
	// 도서관 정보 보여주기
		public void showCurrentLibraryInfo() {
			System.out.println("\n도서관 현재 상태:");
			System.out.println("전체 도서 수 : " + books.size());
			System.out.println("대출 가능 도서 수 : " + getAvailableBooksCount());
			System.out.println("대출 중인 도서 수 : " + getBorrowedBooksCount());
			System.out.println();
		}
	
	// 도서를 추가하는 메서드
	public void addBook(Book book) {
		books.add(book);
		System.out.println("도서가 추가되었습니다: " + book.getTitle());
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
		// 찾은 책 인덱스
		int idx = findBookByISBN(isbn);
		
		if (books.get(idx).checkOut()) {
			System.out.println("도서 대출 성공!");
			System.out.println("대출된 도서 정보:");
			System.out.println(books.get(idx).toString());
		}
		else {
			System.out.println("도서 대출 실패 : 도서 대출중");
		}
	}
	
	
	public void returnBook(String isbn) {
		int idx = findBookByISBN(isbn);
		
		if (books.get(idx).returnBook()) {
			System.out.println("도서 반납 성공!");
			System.out.println("반납된 도서 정보:");
			System.out.println(books.get(idx).toString());
		}
		else {
			System.out.println("도서 반납 실패");
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
