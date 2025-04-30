package lab.book.control;

import java.text.DecimalFormat;
import java.util.*;

import lab.book.entity.*;

public class StatisticsAnalyzer {

	public Map<String, Double> calculateAveragePriceByType(List<Publication> list) {
		// ���� ��
		int m_cnt = 0;
		// �Ҽ� ��
		int n_cnt = 0;
		// ���� ��
		int r_cnt = 0;

		Map<String, Double> map = new HashMap<String, Double>();
		map.put("����", 0.0);
		map.put("�Ҽ�", 0.0);
		map.put("����", 0.0);

		for (Publication p : list) {
			if (getPublicationType(p).equals("����")) {
				m_cnt++;
				map.put("����", map.getOrDefault("����", 0.0) + p.getPrice());
			} else if (getPublicationType(p).equals("�Ҽ�")) {
				n_cnt++;
				map.put("�Ҽ�", map.getOrDefault("�Ҽ�", 0.0) + p.getPrice());
			} else if (getPublicationType(p).equals("����")) {
				r_cnt++;
				map.put("����", map.getOrDefault("����", 0.0) + p.getPrice());
			}
		}

		// ��� ���� ���
		map.put("����", map.getOrDefault("����", 0.0) / m_cnt);
		map.put("�Ҽ�", map.getOrDefault("�Ҽ�", 0.0) / n_cnt);
		map.put("����", map.getOrDefault("����", 0.0) / r_cnt);

		return map;
	}

	// �����
	public Map<String, Double> calculatePublicationDistribution(List<Publication> list) {
		// ���� ��
		int m_cnt = 0;
		// �Ҽ� ��
		int n_cnt = 0;
		// ���� ��
		int r_cnt = 0;

		Map<String, Double> map = new HashMap<String, Double>();
		
		for (Publication p : list) {
			if (getPublicationType(p).equals("����")) {
				m_cnt++;
			} else if (getPublicationType(p).equals("�Ҽ�")) {
				n_cnt++;
			} else if (getPublicationType(p).equals("����")) {
				r_cnt++;
			}
		}
		
		map.put("����", ((double)m_cnt / (double)list.size()) * 100 );
		map.put("�Ҽ�", ((double)n_cnt / (double)list.size()) * 100);
		map.put("����", ((double)r_cnt / (double)list.size()) * 100);
		
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
			return "����";
		} else if (pub instanceof Novel) {
			return "�Ҽ�";
		} else if (pub instanceof ReferenceBook) {
			return "����";
		}
		return "��Ÿ";

	}

	public void printStatistics(List<Publication> list) {
		// ���� ����
		DecimalFormat df = new DecimalFormat("#,###.##");
		
		// Ÿ�Ժ� ��� ����
		Map<String, Double> avgMap = calculateAveragePriceByType(list);
		System.out.println("=== ��� ���� ===");
		avgMap.forEach((k, v) -> {
			System.out.println(k + ":" + df.format(v));
		});
		
		// ���ǹ� ���� ���� (�����)
		Map<String, Double> percentMap = calculatePublicationDistribution(list);
		System.out.println("=== ���� ���� ===");
		percentMap.forEach((k, v) -> {
			System.out.println(k + ":" + df.format(v) + "%");
		});
		
		// Ư�� �ؿ� ���ǵ� ���ǹ� ����
		double yearPubPercent = calculatePublicationRatioByYear(list, "2007");
		System.out.println("=== �ش� �ؿ� ���ǵ� ���ǹ� ===");
		System.out.println("2007�� : " + df.format(yearPubPercent) + "%");
	}

}
