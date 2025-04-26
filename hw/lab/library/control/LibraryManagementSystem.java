package lab.library.control;

import java.util.List;

import lab.library.entity.*;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		Library lib = new Library("중앙 도서관");
		addSampleBooks(lib);
		
		lib.showLibraryInfo();
		
		testFindBook(lib);
		
		testCheckOut(lib);
		
		testReturn(lib);
		
		displayAvailableBooks(lib);
	}

	private static void addSampleBooks(Library library) {
		library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
		library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
		library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
		library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
		library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
		library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
	}

	public static void testFindBook(Library lib) {	
		
		System.out.println("===== 도서 검색 테스트 =====");
		System.out.println("제목으로 검색 결과:");
		String keywordTitle = "Head First Java";
		int idx = lib.findBookByTitle(keywordTitle);
		System.out.println(lib.getAllBooks().get(idx).toString());
		
		System.out.println();
		
		String keywordAuthor = "조영호";
		idx = lib.findBookByAuthor(keywordAuthor);
		System.out.println("저자로 검색 결과");
		System.out.println(lib.getAllBooks().get(idx).toString());
	}
	
	public static void testCheckOut(Library lib) {
		System.out.println("===== 도서 대출 테스트 =====");
		String t_isbn = "978-89-01-14077-4";
		lib.checkOutBook(t_isbn);
		
		lib.showCurrentLibraryInfo();
	}
	
	
	public static void testReturn(Library lib) {
		System.out.println("===== 도서 반납 테스트 =====");
		String t_isbn = "978-89-01-14077-4";
		lib.returnBook(t_isbn);
		
		lib.showCurrentLibraryInfo();
	}
	
	public static void displayAvailableBooks(Library lib) {
		List<Book> availableBooks = lib.getAvailableBooks();
		
		System.out.println("\n===== 대출 가능한 도서 목록 =====\n");
		for (Book b : availableBooks) {
			System.out.println(b.toString());
			System.out.println("------------------------");
		}
	}
	
}
