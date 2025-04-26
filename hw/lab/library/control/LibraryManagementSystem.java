package lab.library.control;

import java.util.List;

import lab.library.entity.*;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		Library lib = new Library("�߾� ������");
		addSampleBooks(lib);
		
		lib.showLibraryInfo();
		
		testFindBook(lib);
		
		testCheckOut(lib);
		
		testReturn(lib);
		
		displayAvailableBooks(lib);
	}

	private static void addSampleBooks(Library library) {
		library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
		library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
		library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
		library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
		library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
		library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
	}

	public static void testFindBook(Library lib) {	
		
		System.out.println("===== ���� �˻� �׽�Ʈ =====");
		System.out.println("�������� �˻� ���:");
		String keywordTitle = "Head First Java";
		int idx = lib.findBookByTitle(keywordTitle);
		System.out.println(lib.getAllBooks().get(idx).toString());
		
		System.out.println();
		
		String keywordAuthor = "����ȣ";
		idx = lib.findBookByAuthor(keywordAuthor);
		System.out.println("���ڷ� �˻� ���");
		System.out.println(lib.getAllBooks().get(idx).toString());
	}
	
	public static void testCheckOut(Library lib) {
		System.out.println("===== ���� ���� �׽�Ʈ =====");
		String t_isbn = "978-89-01-14077-4";
		lib.checkOutBook(t_isbn);
		
		lib.showCurrentLibraryInfo();
	}
	
	
	public static void testReturn(Library lib) {
		System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
		String t_isbn = "978-89-01-14077-4";
		lib.returnBook(t_isbn);
		
		lib.showCurrentLibraryInfo();
	}
	
	public static void displayAvailableBooks(Library lib) {
		List<Book> availableBooks = lib.getAvailableBooks();
		
		System.out.println("\n===== ���� ������ ���� ��� =====\n");
		for (Book b : availableBooks) {
			System.out.println(b.toString());
			System.out.println("------------------------");
		}
	}
	
}
