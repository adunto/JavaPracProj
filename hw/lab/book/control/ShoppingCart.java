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
		System.out.println("�߰��� : " + items.get(items.size()-1).toString());
	}

	public boolean removeItem(String title) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getTitle().equals(title)) {
				items.remove(i);
				System.out.println("���ŵ� : " + title);
				return true;
			}
		}
		System.out.println("�ش� å�� ã�� ���߽��ϴ�. : " + title);

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
				System.out.println(item + " : �׸� ����");
			}
		}
		
		System.out.println("�� ���� : " + calculateTotalPrice());
		System.out.println("���� ���� ���� : " + calculateDiscountedPrice());
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
				System.out.println(item + " : �׸� ����");
			}
		}
		
		return result;
	}
	
	public void printStatistics() {
		int novelCnt = 0;
		int magazineCnt = 0;
		int referenceBookCnt = 0;
		
		System.out.println("��ٱ��Ͽ� ��� ���ǹ� �� : " + items.size());
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
		System.out.println("-�Ҽ�: " + (double)((novelCnt)/items.size()) * 100);
		System.out.println("-����: " + (double)((referenceBookCnt)/items.size()) * 100);
		System.out.println("-����: " + (double)((magazineCnt)/items.size()) * 100);
	}
	
}
