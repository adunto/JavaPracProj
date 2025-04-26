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
	
	// �Ա�
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println(amount + "���� �ԱݵǾ����ϴ�. ���� �ܾ� : " + balance + "��");
	}
	
	// ���
	public void withdraw(double amount) {
		try {
			double result = balance - amount;
			if (result < 0) {
				throw new WithdrawalLimitExceededException("�ܾ� ����");
			}
			else {
				this.balance = result;
				System.out.println(amount + "���� ��ݵǾ����ϴ�. ���� �ܾ� : " + balance + "��");
			}
		} catch (WithdrawalLimitExceededException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String toString() {
		return "���¹�ȣ: " + accountNumber + ", ������:" + ownerName + ", �ܾ�: " + balance;
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
