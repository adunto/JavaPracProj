package lab.bank.entity;

import lab.bank.entity.*;
import lab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account{
	private double withdrawalLimit;	// 출금 한도
	
	public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
		super(accountNumber, ownerName, initialBalance);
		this.withdrawalLimit = withdrawalLimit;
	}
	
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	
	@Override
	public void withdraw(double amount) {
		try {
			if (amount > withdrawalLimit) {
				throw new WithdrawalLimitExceededException("예외 발생: 출금 한도를 초과했습니다. 한도 : " + withdrawalLimit + "원");
			}
			else {
				super.withdraw(amount);
			}
		}
		catch (WithdrawalLimitExceededException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		String s = super.toString() + ", 출금 한도: " + withdrawalLimit + "원";
		return s;
	}
}
