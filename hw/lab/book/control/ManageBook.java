package lab.book.control;

import lab.book.entity.*;

public class ManageBook {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		
		cart.addItem(((Publication)new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�")));
		cart.addItem(((Publication)new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�")));
		cart.addItem(((Publication)new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�")));
		cart.addItem(((Publication)new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�")));
		cart.addItem(((Publication)new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������")));
		cart.addItem(((Publication)new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�")));
		cart.addItem(((Publication)new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�")));
		
		cart.displayCart();
		
		//	3��° ����(�ε��� 2)�� ������ �����ϱ� ���� ���� ������ �����մϴ�.
		int price = cart.getItems().get(2).getPrice();
		
		//	modifyPrice() �޼��带 ȣ���Ͽ� ������ �����մϴ�.
		cart.getItems().get(2).setPrice(modifyPrice(cart.getItems().get(2)));
		
		//	���� �� ���ݰ� ������ ����Ͽ� ����մϴ�.
		System.out.println("=== ���� ���� ===");
		System.out.println(cart.getItems().get(2).getTitle() + " ���� �� ����: " + price);
		System.out.println(cart.getItems().get(2).getTitle() + " ���� �� ����: " + cart.getItems().get(2).getPrice());
		System.out.println("����: " + (price - cart.getItems().get(2).getPrice()));
		
		StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
		
		System.out.println("=== ���ǹ� ��� �м� ===");
		analyzer.printStatistics(cart.getItems());
	}
	
	public static int modifyPrice(Publication p) {
		if (p instanceof Novel) {
			return (int)(p.getPrice() * 0.8);
		}
		else if (p instanceof Magazine) {
			return (int)(p.getPrice() * 0.6);
		}
		else if (p instanceof ReferenceBook) {
			return (int)(p.getPrice() * 0.9);
		}
		else {
			return 0;
		}
	}
}
