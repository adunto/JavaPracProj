package workshop.book.control;

import java.util.*;
import workshop.book.entity.*;

public class ManageBook {

	public static void main(String[] args) {
		// Publication Ÿ�� �迭 ���� �� ����
		List<Publication> pubList = new ArrayList<>();
		
		pubList.add(new Magazine("����ũ�μ���Ʈ","2007-10-01",328,9900,"�ſ�"));
		pubList.add(new Magazine("�濵����ǻ��","2007-10-03",316,9000,"�ſ�"));
		pubList.add(new Novel("���߿�","2007-07-01",396,9800,"����������������","����Ҽ�"));
		pubList.add(new Novel("���ѻ꼺","2007-04-14",383,11000,"����","���ϼҼ�"));
		pubList.add(new ReferenceBook("�ǿ��������α׷���","2007-01-14",496,25000,"����Ʈ�������"));
	
		System.out.println("==== Book ���� ��� ====");
		for(Publication p : pubList) {
			System.out.println(p.toString());
		}
		
		// 3��° ��ǰ ���� ����
		System.out.println("\n==== �������� ���� �� ====");
		System.out.println(pubList.get(2).toString() +
				" : " + pubList.get(2).getPrice());
		
		System.out.println("\n==== �������� ���� �� ====");
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
