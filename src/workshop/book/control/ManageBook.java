package workshop.book.control;

import java.util.*;
import workshop.book.entity.*;

public class ManageBook {

	public static void main(String[] args) {
		// Publication 타입 배열 선언 및 생성
		List<Publication> pubList = new ArrayList<>();
		
		Publication p1 = new Magazine();
		Publication p2 = new Novel();
		pubList.add(p1);
		pubList.add(p2);
		
		for(Publication p : pubList) {
			String type = p.getClass().getSimpleName();
			System.out.println(type);
		}
		
	}

}
