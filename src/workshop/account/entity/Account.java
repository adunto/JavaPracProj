package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;

	// 남은 잔액 값 할당 메서드
	public void setBalance(int newBalance) {
		this.balance = newBalance;
	}

	// 남은 잔액 값 얻기 메서드
	public int getBalance() {
		return this.balance;
	}

	// custId setter
	public void setCustId(String newCustId) {
		this.custId = newCustId;
	}

	// custId getter
	public String getCustId() {
		return this.custId;
	}

	// acctId setter
	public void setAcctId(String newAcctId) {
		this.acctId = newAcctId;
	}

	// acctId getter
	public String getAcctId() {
		return this.acctId;
	}

	// 계좌잔액을 입력한 금액만큼 증가(입금)시키는 메서드
	public void deposit(int amount) {
		if (amount > 0) {
			this.balance += amount;
		}
	}

	// 계좌잔액을 입력한 금액만큼 감소(출금)시키는 메서드
	public void withdraw(int amount) {
		if (isValid(amount)) {
			this.balance -= amount;
		}
	}
	
	// 출금 가능 여부
	private boolean isValid(int amount) {
		int result = this.balance - amount;
		if (result < 0) {
			return false;
		}
		else {
			return true;
		}
	}
}

