package lab.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBalanceException {
	public WithdrawalLimitExceededException(String msg) {
		super(msg);
	}
}
