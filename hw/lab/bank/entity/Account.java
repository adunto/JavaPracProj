package lab.bank.entity;

import lab.bank.exception.WithdrawalLimitExceededException;

public class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	public Account(String accountNumber, String ownerName, double initialBalance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = initialBalance;
	}
	
	// 입금
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println(amount + "원이 입금되었습니다. 현재 잔액 : " + balance + "원");
	}
	
	// 출금
	public void withdraw(double amount) {
		try {
			double result = balance - amount;
			if (result < 0) {
				throw new WithdrawalLimitExceededException("잔액 부족");
			}
			else {
				this.balance = result;
				System.out.println(amount + "원이 출금되었습니다. 현재 잔액 : " + balance + "원");
			}
		} catch (WithdrawalLimitExceededException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String toString() {
		return "계좌번호: " + accountNumber + ", 소유자:" + ownerName + ", 잔액: " + balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public double getBalance() {
		return balance;
	}
	
}
