package lab.book.control;

import java.util.*;

import lab.book.entity.*;

public class ShoppingCart {
	private List<Publication> items;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}
	
	public List<Publication> getItems() {
		return items;
	}
	

	public void addItem(Publication item) {
		items.add(item);
		System.out.println("추가됨 : " + items.get(items.size()-1).toString());
	}

	public boolean removeItem(String title) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getTitle().equals(title)) {
				items.remove(i);
				System.out.println("제거됨 : " + title);
				return true;
			}
		}
		System.out.println("해당 책을 찾지 못했습니다. : " + title);

		return false;
	}

	public void displayCart() {
		int idx = 1;
		for (Publication item : items) {
			System.out.print(idx++ + ". ");
			if (item instanceof Novel) {
				System.out.println(((Novel) item).toString());
			}
			else if (item instanceof Magazine) {
				System.out.println(((Magazine) item).toString());
			}
			else if (item instanceof ReferenceBook) {
				System.out.println(((ReferenceBook) item).toString());
			}
			else {
				System.out.println(item + " : 항목 오류");
			}
		}
		
		System.out.println("총 가격 : " + calculateTotalPrice());
		System.out.println("할인 적용 가격 : " + calculateDiscountedPrice());
	}
	
	public int calculateTotalPrice() {
		int result = 0;
		for (Publication item : items) {
			result += item.getPrice();
		}
		
		return result;
	}
	
	public int calculateDiscountedPrice() {
		int result = 0;
		for (Publication item : items) {
			if (item instanceof Novel) {
				result += (int)(item.getPrice() * 0.85);
			}
			else if (item instanceof Magazine) {
				result += (int)(item.getPrice() * 0.9);
			}
			else if (item instanceof ReferenceBook) {
				result += (int)(item.getPrice() * 0.8);
			}
			else {
				System.out.println(item + " : 항목 오류");
			}
		}
		
		return result;
	}
	
	public void printStatistics() {
		int novelCnt = 0;
		int magazineCnt = 0;
		int referenceBookCnt = 0;
		
		System.out.println("장바구니에 담긴 출판물 수 : " + items.size());
		for (Publication item : items) {
			if (item instanceof Novel) {
				novelCnt++;
			}
			else if (item instanceof Magazine) {
				magazineCnt++;
			}
			else if (item instanceof ReferenceBook) {
				referenceBookCnt++;
			}
		}
		System.out.println("-소설: " + (double)((novelCnt)/items.size()) * 100);
		System.out.println("-참고서: " + (double)((referenceBookCnt)/items.size()) * 100);
		System.out.println("-잡지: " + (double)((magazineCnt)/items.size()) * 100);
	}
	
}
