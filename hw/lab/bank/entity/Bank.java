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
		// 저축 계좌 만들기
		String accountName = "AC" + Integer.toString(nextAccountNumber);
		this.nextAccountNumber++;
		Account ac = new SavingsAccount(accountName, ownerName, initialBalance, interestRate);
		accounts.add(ac);

		String s = "저축 계좌가 생성되었습니다. " +
					ac.toString() + ", 이자율: " + interestRate + "%";
		return s;
	}

	public String createCheckingAccount(String ownerName, double initialBalance, double interestRate) {
		// 체킹 계좌 만들기
		String accountName = "AC" + Integer.toString(nextAccountNumber);
		this.nextAccountNumber++;
		Account ac = new CheckingAccount(accountName, ownerName, initialBalance, interestRate);
		accounts.add(ac);

		String s = "체킹 계좌가 생성되었습니다. " +
					ac.toString() + ", 출금 한도: " + interestRate + "원";
		
		return s;
	}

	public Account findAccount(String accountNumber) {
		try {
			for (Account account : accounts) {
				if (account.getAccountNumber().equals(accountNumber)) {
					return account;
				}
			}
			throw new AccountNotFoundException("예외 발생: 계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
		}
		catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void deposit(String accountNumber, double amount) {
		// findAccount로 찾은 계좌에 amount 입금
		findAccount(accountNumber).deposit(amount);
	}

	public void withdraw(String accountNumber, double amount) {
		// findAccount로 찾은 계좌에서 amount 만큼 출금 (예외 처리 (잔액 부족 등 ))
		try {
			Account ac = findAccount(accountNumber);
			if (ac.getBalance() - amount < 0) {
				throw new InsufficientBalanceException("예외 발생: 잔액 부족");
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
		// from 에서 to 로 amount 만큼 송금
		// from 계좌에서 예외 처리
		Account fromAc = findAccount(fromAccountNumber);
		Account toAc = findAccount(toAccountNumber);
		try {
			if (fromAc.getBalance() - amount < 0) {
				throw new InsufficientBalanceException("예외 발생: 이체 잔액 부족");
			}
			else {
				fromAc.withdraw(amount);
				toAc.deposit(amount);
				System.out.println(amount + "원이 " + fromAccountNumber + "에서 " + toAccountNumber + "로 송금되었습니다.");
			}
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
	}

	public void printAllAcounts() {
		System.out.println("=== 모든 계좌 목록 ===");
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
