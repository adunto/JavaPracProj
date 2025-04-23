package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;

	// ���� �ܾ� �� �Ҵ� �޼���
	public void setBalance(int newBalance) {
		this.balance = newBalance;
	}

	// ���� �ܾ� �� ��� �޼���
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

	// �����ܾ��� �Է��� �ݾ׸�ŭ ����(�Ա�)��Ű�� �޼���
	public void deposit(int amount) {
		if (amount > 0) {
			this.balance += amount;
		}
	}

	// �����ܾ��� �Է��� �ݾ׸�ŭ ����(���)��Ű�� �޼���
	public void withdraw(int amount) {
		if (isValid(amount)) {
			this.balance -= amount;
		}
	}
	
	// ��� ���� ����
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

