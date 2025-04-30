package lab.book.control;

import lab.book.entity.*;

public class ManageBook {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		
		cart.addItem(((Publication)new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월")));
		cart.addItem(((Publication)new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월")));
		cart.addItem(((Publication)new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설")));
		cart.addItem(((Publication)new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설")));
		cart.addItem(((Publication)new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학")));
		cart.addItem(((Publication)new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설")));
		cart.addItem(((Publication)new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")));
		
		cart.displayCart();
		
		//	3번째 도서(인덱스 2)의 가격을 변경하기 전에 원래 가격을 저장합니다.
		int price = cart.getItems().get(2).getPrice();
		
		//	modifyPrice() 메서드를 호출하여 가격을 변경합니다.
		cart.getItems().get(2).setPrice(modifyPrice(cart.getItems().get(2)));
		
		//	변경 후 가격과 차액을 계산하여 출력합니다.
		System.out.println("=== 가격 변경 ===");
		System.out.println(cart.getItems().get(2).getTitle() + " 변경 전 가격: " + price);
		System.out.println(cart.getItems().get(2).getTitle() + " 변경 후 가격: " + cart.getItems().get(2).getPrice());
		System.out.println("차액: " + (price - cart.getItems().get(2).getPrice()));
		
		StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
		
		System.out.println("=== 출판물 통계 분석 ===");
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
