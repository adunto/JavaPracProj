package lab.bank.control;

import lab.bank.entity.*;

public class BankDemo {

	public static void main(String[] args) {
		Bank bank = new Bank();

		System.out.println("=== 계좌 생성 ===");
		System.out.println(bank.createSavingAccount("홍길동", 10000, 3));
		System.out.println(bank.createCheckingAccount("김철수", 20000, 5000));
		System.out.println(bank.createSavingAccount("이영희", 30000, 2));
		
		System.out.println();
		bank.printAllAcounts();
		
		System.out.println();
		System.out.println("=== 입금/출금 테스트 ===");
		bank.findAccount("AC1000").deposit(5000);
		bank.findAccount("AC1001").withdraw(3000);
		
		System.out.println();
		System.out.println("=== 이자 적용 테스트 ===");
		Account target = bank.findAccount("AC1000");
		if (target instanceof SavingsAccount) {
			((SavingsAccount) target).applyInterest();
		}
		
		System.out.println();
		System.out.println("=== 계좌 이체 테스트 ===");
		bank.transfer("AC1000", "AC1002", 1000);
		
		System.out.println();
		bank.printAllAcounts();
		
		System.out.println();
		System.out.println("=== 예외 발생 테스트 ===");
		target = bank.findAccount("AC1001");
		if (target instanceof CheckingAccount) {
			((CheckingAccount) target).withdraw(6000);
			((CheckingAccount) target).withdraw(10000);
		}
		bank.findAccount("AC9999");
	}

}
