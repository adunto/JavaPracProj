package lab.book.entity;

public class ReferenceBook extends Publication {
	private String field;
	
	public ReferenceBook() {
		// TODO Auto-generated constructor stub
	}
	
	public ReferenceBook(String title, String publishDate, int page, int price, String field) {
		super(title, publishDate, page, price);
		this.field = field;
	}
	
	public String getField() {
		return field;
	}
	
	@Override
	public String toString() {
		String s = super.getTitle() + " [����] �о�:" + field + ", " +
				super.getPage() + "��, " + super.getPrice() + "��, ������:" + super.getPublishDate();
		return s;
	}
	
}
