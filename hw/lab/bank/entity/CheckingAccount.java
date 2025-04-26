package lab.bank.entity;

import lab.bank.entity.*;
import lab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account{
	private double withdrawalLimit;	// ��� �ѵ�
	
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
				throw new WithdrawalLimitExceededException("���� �߻�: ��� �ѵ��� �ʰ��߽��ϴ�. �ѵ� : " + withdrawalLimit + "��");
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
		String s = super.toString() + ", ��� �ѵ�: " + withdrawalLimit + "��";
		return s;
	}
}
