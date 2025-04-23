package workshop.account.test;

import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class TestAccount {
	public void showInfo(Account ac) {
		// �� ���� ���
		System.out.println("------������------");
		System.out.println("����ȣ : " + ac.getCustId());
		System.out.println("���¹�ȣ : " + ac.getAcctId());
		System.out.println("�ܾ� : " + ac.getBalance());
		System.out.println("-----------------");
	}

	public static void main(String[] args) {
		TestAccount ta = new TestAccount();
		
		Account ac = new Account();
		ac.setCustId("A1100");
		ac.setAcctId("221-22-3477");
		ac.setBalance(100000);

		ta.showInfo(ac);
		
		// �ܾ� 10000�� ����(�Ա�)
		int amount = 10000;
		ac.deposit(amount);
		System.out.println("\n" + amount + "�� �Աݵ�.\n");
		ta.showInfo(ac);
		
		// �ܾ��� 20000�� ����(���)
		amount = 20000;
		try {
			ac.withdraw(amount);
			ac.withdraw(10000000);
		} catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("\n" + amount + "�� ��ݵ�.\n");
		ta.showInfo(ac);

	}
}
