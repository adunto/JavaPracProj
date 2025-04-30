package lab.book.entity;

public class Magazine extends Publication{
	private String publishPeriod;
	
	public Magazine() {
		// TODO Auto-generated constructor stub
	}
	
	public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
		super(title, publishDate, page, price);
		this.publishPeriod = publishPeriod;
	}
	
	@Override
	public String toString() {
		String s = super.getTitle() + " [����] �����ֱ�:" + publishPeriod + ", " +
					super.getPage() + "��, " + super.getPrice() + "��, ������:" + super.getPublishDate();
		return s;
	}
	
}
