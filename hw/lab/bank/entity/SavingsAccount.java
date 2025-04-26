package lab.bank.entity;

public class SavingsAccount extends Account{
	private double interestRate;
	
	public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
		super(accountNumber, ownerName, initialBalance);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void applyInterest() {
		super.deposit(super.getBalance() * (interestRate / 100.0));
	}
	
	@Override
	public String toString() {
		String s = super.toString() + ", ÀÌÀÚÀ²: " + interestRate + "%";
		return s;
	}
}
