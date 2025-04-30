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
		String s = super.getTitle() + " [참고서] 분야:" + field + ", " +
				super.getPage() + "쪽, " + super.getPrice() + "원, 출판일:" + super.getPublishDate();
		return s;
	}
	
}
