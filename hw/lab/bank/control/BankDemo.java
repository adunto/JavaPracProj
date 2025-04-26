package lab.bank.control;

import lab.bank.entity.*;

public class BankDemo {

	public static void main(String[] args) {
		Bank bank = new Bank();

		System.out.println("=== ���� ���� ===");
		System.out.println(bank.createSavingAccount("ȫ�浿", 10000, 3));
		System.out.println(bank.createCheckingAccount("��ö��", 20000, 5000));
		System.out.println(bank.createSavingAccount("�̿���", 30000, 2));
		
		System.out.println();
		bank.printAllAcounts();
		
		System.out.println();
		System.out.println("=== �Ա�/��� �׽�Ʈ ===");
		bank.findAccount("AC1000").deposit(5000);
		bank.findAccount("AC1001").withdraw(3000);
		
		System.out.println();
		System.out.println("=== ���� ���� �׽�Ʈ ===");
		Account target = bank.findAccount("AC1000");
		if (target instanceof SavingsAccount) {
			((SavingsAccount) target).applyInterest();
		}
		
		System.out.println();
		System.out.println("=== ���� ��ü �׽�Ʈ ===");
		bank.transfer("AC1000", "AC1002", 1000);
		
		System.out.println();
		bank.printAllAcounts();
		
		System.out.println();
		System.out.println("=== ���� �߻� �׽�Ʈ ===");
		target = bank.findAccount("AC1001");
		if (target instanceof CheckingAccount) {
			((CheckingAccount) target).withdraw(6000);
			((CheckingAccount) target).withdraw(10000);
		}
		bank.findAccount("AC9999");
	}

}
