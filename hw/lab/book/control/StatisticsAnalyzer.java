package lab.book.control;

import java.text.DecimalFormat;
import java.util.*;

import lab.book.entity.*;

public class StatisticsAnalyzer {

	public Map<String, Double> calculateAveragePriceByType(List<Publication> list) {
		// 잡지 수
		int m_cnt = 0;
		// 소설 수
		int n_cnt = 0;
		// 참고서 수
		int r_cnt = 0;

		Map<String, Double> map = new HashMap<String, Double>();
		map.put("잡지", 0.0);
		map.put("소설", 0.0);
		map.put("참고서", 0.0);

		for (Publication p : list) {
			if (getPublicationType(p).equals("잡지")) {
				m_cnt++;
				map.put("잡지", map.getOrDefault("잡지", 0.0) + p.getPrice());
			} else if (getPublicationType(p).equals("소설")) {
				n_cnt++;
				map.put("소설", map.getOrDefault("소설", 0.0) + p.getPrice());
			} else if (getPublicationType(p).equals("참고서")) {
				r_cnt++;
				map.put("참고서", map.getOrDefault("참고서", 0.0) + p.getPrice());
			}
		}

		// 평균 가격 계산
		map.put("잡지", map.getOrDefault("잡지", 0.0) / m_cnt);
		map.put("소설", map.getOrDefault("소설", 0.0) / n_cnt);
		map.put("참고서", map.getOrDefault("참고서", 0.0) / r_cnt);

		return map;
	}

	// 백분율
	public Map<String, Double> calculatePublicationDistribution(List<Publication> list) {
		// 잡지 수
		int m_cnt = 0;
		// 소설 수
		int n_cnt = 0;
		// 참고서 수
		int r_cnt = 0;

		Map<String, Double> map = new HashMap<String, Double>();
		
		for (Publication p : list) {
			if (getPublicationType(p).equals("잡지")) {
				m_cnt++;
			} else if (getPublicationType(p).equals("소설")) {
				n_cnt++;
			} else if (getPublicationType(p).equals("참고서")) {
				r_cnt++;
			}
		}
		
		map.put("잡지", ((double)m_cnt / (double)list.size()) * 100 );
		map.put("소설", ((double)n_cnt / (double)list.size()) * 100);
		map.put("참고서", ((double)r_cnt / (double)list.size()) * 100);
		
		return map;
	}

	public double calculatePublicationRatioByYear(List<Publication> list, String year) {
		int cnt = 0;
		for (Publication p : list) {
			String pYear = p.getPublishDate().split("-")[0];
			if (year.equals(pYear)) cnt++;
		}
		
		return ((double)cnt / (double)list.size() ) * 100;
	}

	private String getPublicationType(Publication pub) {
		if (pub instanceof Magazine) {
			return "잡지";
		} else if (pub instanceof Novel) {
			return "소설";
		} else if (pub instanceof ReferenceBook) {
			return "참고서";
		}
		return "기타";

	}

	public void printStatistics(List<Publication> list) {
		// 숫자 포맷
		DecimalFormat df = new DecimalFormat("#,###.##");
		
		// 타입별 평균 가격
		Map<String, Double> avgMap = calculateAveragePriceByType(list);
		System.out.println("=== 평균 가격 ===");
		avgMap.forEach((k, v) -> {
			System.out.println(k + ":" + df.format(v));
		});
		
		// 출판물 유형 분포 (백분율)
		Map<String, Double> percentMap = calculatePublicationDistribution(list);
		System.out.println("=== 유형 분포 ===");
		percentMap.forEach((k, v) -> {
			System.out.println(k + ":" + df.format(v) + "%");
		});
		
		// 특정 해에 출판된 출판물 비율
		double yearPubPercent = calculatePublicationRatioByYear(list, "2007");
		System.out.println("=== 해당 해에 출판된 출판물 ===");
		System.out.println("2007년 : " + df.format(yearPubPercent) + "%");
	}

}
