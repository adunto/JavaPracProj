package workshop.account.test;

import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class TestAccount {
	public void showInfo(Account ac) {
		// 고객 정보 출력
		System.out.println("------고객정보------");
		System.out.println("고객번호 : " + ac.getCustId());
		System.out.println("계좌번호 : " + ac.getAcctId());
		System.out.println("잔액 : " + ac.getBalance());
		System.out.println("-----------------");
	}

	public static void main(String[] args) {
		TestAccount ta = new TestAccount();
		
		Account ac = new Account();
		ac.setCustId("A1100");
		ac.setAcctId("221-22-3477");
		ac.setBalance(100000);

		ta.showInfo(ac);
		
		// 잔액 10000원 증가(입금)
		int amount = 10000;
		ac.deposit(amount);
		System.out.println("\n" + amount + "원 입금됨.\n");
		ta.showInfo(ac);
		
		// 잔액을 20000원 감소(출금)
		amount = 20000;
		try {
			ac.withdraw(amount);
			ac.withdraw(10000000);
		} catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("\n" + amount + "원 출금됨.\n");
		ta.showInfo(ac);

	}
}
