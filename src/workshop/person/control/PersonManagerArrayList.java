package workshop.person.control;

import java.util.*;

import workshop.person.entity.PersonEntity;

public class PersonManagerArrayList {
	public static void main(String[] args) {
		
//		ArrayList<PersonEntity> list = new ArrayList<>();
		
		List<PersonEntity> personList = new ArrayList<>();
		
		PersonManagerArrayList pm = new PersonManagerArrayList();
		pm.printTitle("@@@ �ι� ���� ��ȸ �ý��� @@@");
		pm.printTitleLine();
		pm.fillPersons(personList);

		// persons ���� ���
		pm.showPerson(personList);

		// ������ ���� �˻� ���
		char searchParam = '��';
		int g_count = pm.findByGender(personList, searchParam);
		System.out.println("���� : " + searchParam + " (��)�� " + g_count + "�� �Դϴ�.");

		// �̸� ã��
		String searchName = "���ϴ�";
		pm.showPerson(personList, searchName);
	}

	public void showPerson(List<PersonEntity> persons) {
		for (PersonEntity person : persons) {
			System.out.println(person.getName() + "\t" + person.getGender() + "\t" + person.getPhone());
			// ������
		}
	}

	public void showPerson(List<PersonEntity> persons, String name) {
		System.out.println("-- �̸� : " + "'" + name + "'" + " (��)�� ã�� ����Դϴ�.");
		for (PersonEntity person : persons) {
			if (person.getName().equals(name)) {
				System.out.println("[�̸�] " + person.getName());
				System.out.println("[����] " + person.getGender());
				System.out.println("[��ȭ��ȣ] " + person.getPhone());
				System.out.println("[�ּ�] " + person.getAddress());
			}
		}
	}

	public void fillPersons(List<PersonEntity> persons) {
		persons.add(new PersonEntity("�̼�ȣ", "7212121028102", "��õ ��籸", "032-392-2932"));
		persons.add(new PersonEntity("���ϴ�", "7302132363217", "���� ������", "02-362-1932"));
		persons.add(new PersonEntity("�ڿ���", "7503111233201", "���� ���ϱ�", "02-887-1542"));
		persons.add(new PersonEntity("���μ�", "7312041038988", "���� ������", "032-384-2223"));
		persons.add(new PersonEntity("ȫ����", "7606221021341", "���� ��õ��", "02-158-7333"));
		persons.add(new PersonEntity("�̹̼�", "7502142021321", "���� ������", "02-323-1934"));
		persons.add(new PersonEntity("�ڼ���", "7402061023101", "���� ���α�", "02-308-0932"));
		persons.add(new PersonEntity("������", "7103282025101", "���� ����", "02-452-0939"));
		persons.add(new PersonEntity("Ȳ����", "7806231031101", "��õ �߱�", "032-327-2202"));
		persons.add(new PersonEntity("��ö��", "7601211025101", "��õ ��籸", "032-122-7832"));
	}

	public int findByGender(List<PersonEntity> persons, char gender) {
		int cnt = 0;
		for (PersonEntity p : persons) {
			if (p.getGender() == gender) {
				cnt++;
			}
		}

		return cnt;
	}

	private void printTitle(String title) {
		System.out.println(title);
	}

	private void printTitleLine() {
		System.out.println("===============================");
	}
}
