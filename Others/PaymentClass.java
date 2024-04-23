package Others;

public class PaymentClass {


public PaymentClass(String cardNumber, int balance) {
		super();
		this.cardNumber = cardNumber;
		this.balance = balance;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	private String cardNumber;
	private int balance;
	
	@Override
	public String toString() {
		return "PaymentClass [cardNumber=" + cardNumber + ", balance=" + balance + "]";
	}
}
