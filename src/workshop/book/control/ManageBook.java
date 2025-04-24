package workshop.book.control;

import java.util.*;
import workshop.book.entity.*;

public class ManageBook {

	public static void main(String[] args) {
		// Publication 타입 배열 선언 및 생성
		List<Publication> pubList = new ArrayList<>();
		
		pubList.add(new Magazine("마이크로소프트","2007-10-01",328,9900,"매월"));
		pubList.add(new Magazine("경영과컴퓨터","2007-10-03",316,9000,"매월"));
		pubList.add(new Novel("빠삐용","2007-07-01",396,9800,"베르나르베르베르","현대소설"));
		pubList.add(new Novel("남한산성","2007-04-14",383,11000,"김훈","대하소설"));
		pubList.add(new ReferenceBook("실용주의프로그래머","2007-01-14",496,25000,"소프트웨어공학"));
	
		System.out.println("==== Book 정보 출력 ====");
		for(Publication p : pubList) {
			System.out.println(p.toString());
		}
		
		// 3번째 작품 가격 변경
		System.out.println("\n==== 가격정보 변경 전 ====");
		System.out.println(pubList.get(2).toString() +
				" : " + pubList.get(2).getPrice());
		
		System.out.println("\n==== 가격정보 변경 후 ====");
		modifyPrice(pubList.get(2));
		System.out.println(pubList.get(2).toString() +
				" : " + pubList.get(2).getPrice());
		
	}
	
	public static void modifyPrice(Publication pub) {
		double rate = 1.0;
		if (pub instanceof Magazine) {
			rate = 0.6;
			int rst = (int)(pub.getPrice() * rate);
			pub.setPrice(rst);
		}
		else if (pub instanceof Novel) {
			rate = 0.8;
			int rst = (int)(pub.getPrice() * rate);
			pub.setPrice(rst);
		}
		else if (pub instanceof ReferenceBook) {
			rate = 0.9;
			int rst = (int)(pub.getPrice() * rate);
			pub.setPrice(rst);
		}
		else {
			rate = 1.0;
		}
	}

}
