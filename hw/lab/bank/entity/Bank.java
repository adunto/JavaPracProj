package lab.bank.entity;

import java.util.*;

import lab.bank.exception.AccountNotFoundException;
import lab.bank.exception.InsufficientBalanceException;
import workshop.account.entity.*;

public class Bank {
	private List<Account> accounts;
	private int nextAccountNumber;

	public Bank() {
		this.accounts = new ArrayList<>();
		this.nextAccountNumber = 1000;
	}

	public String createSavingAccount(String ownerName, double initialBalance, double interestRate) {
		// ���� ���� �����
		String accountName = "AC" + Integer.toString(nextAccountNumber);
		this.nextAccountNumber++;
		Account ac = new SavingsAccount(accountName, ownerName, initialBalance, interestRate);
		accounts.add(ac);

		String s = "���� ���°� �����Ǿ����ϴ�. " +
					ac.toString() + ", ������: " + interestRate + "%";
		return s;
	}

	public String createCheckingAccount(String ownerName, double initialBalance, double interestRate) {
		// üŷ ���� �����
		String accountName = "AC" + Integer.toString(nextAccountNumber);
		this.nextAccountNumber++;
		Account ac = new CheckingAccount(accountName, ownerName, initialBalance, interestRate);
		accounts.add(ac);

		String s = "üŷ ���°� �����Ǿ����ϴ�. " +
					ac.toString() + ", ��� �ѵ�: " + interestRate + "��";
		
		return s;
	}

	public Account findAccount(String accountNumber) {
		try {
			for (Account account : accounts) {
				if (account.getAccountNumber().equals(accountNumber)) {
					return account;
				}
			}
			throw new AccountNotFoundException("���� �߻�: ���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
		}
		catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void deposit(String accountNumber, double amount) {
		// findAccount�� ã�� ���¿� amount �Ա�
		findAccount(accountNumber).deposit(amount);
	}

	public void withdraw(String accountNumber, double amount) {
		// findAccount�� ã�� ���¿��� amount ��ŭ ��� (���� ó�� (�ܾ� ���� �� ))
		try {
			Account ac = findAccount(accountNumber);
			if (ac.getBalance() - amount < 0) {
				throw new InsufficientBalanceException("���� �߻�: �ܾ� ����");
			}
			else {
				ac.withdraw(amount);
			}
		}
		catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
	}

	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
		// from ���� to �� amount ��ŭ �۱�
		// from ���¿��� ���� ó��
		Account fromAc = findAccount(fromAccountNumber);
		Account toAc = findAccount(toAccountNumber);
		try {
			if (fromAc.getBalance() - amount < 0) {
				throw new InsufficientBalanceException("���� �߻�: ��ü �ܾ� ����");
			}
			else {
				fromAc.withdraw(amount);
				toAc.deposit(amount);
				System.out.println(amount + "���� " + fromAccountNumber + "���� " + toAccountNumber + "�� �۱ݵǾ����ϴ�.");
			}
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
	}

	public void printAllAcounts() {
		System.out.println("=== ��� ���� ��� ===");
		for (Account account : accounts) {
			if (account instanceof CheckingAccount) {
				CheckingAccount ac = (CheckingAccount)account;
				System.out.println(ac.toString());
			}
			else {
				SavingsAccount ac = (SavingsAccount)account;
				System.out.println(ac.toString());
			}
		}
		System.out.println("================");
	}
}
