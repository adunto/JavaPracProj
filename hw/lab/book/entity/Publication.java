package lab.book.entity;

public class Publication {
	private String title;
	private String publishDate;
	private int page;
	private int price;

	public Publication() {
		// TODO Auto-generated constructor stub
	}

	public Publication(String title, String publishDate, int page, int price) {
		this.title = title;
		this.publishDate = publishDate;
		this.page = page;
		this.price = price;
	}


	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public int getPage() {
		return page;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return title;
	}
}
