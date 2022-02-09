
public class CreditCard extends InterestAccount{

	public CreditCard(String userName,int money, double interest) {
		super(userName,money,interest);
	}
	
	public void withDraw(double money) {
		if(getMoney()-money>=100) {
			super.withDraw(money);
		}else {
			System.out.println("You don't meet the expectation for withdrawing!");
		}
	}
	
	public void addInterest() {
		super.deposit(getMoney()*getInterest()-10);
	}
	
	public String toString() {
		return super.toString();
	}
	
	public static void main(String[] args) {
		CreditCard Yiran=new CreditCard("Yiran",500,0.1);
		Yiran.addInterest();
		System.out.println(Yiran);
		Yiran.withDraw(300);
		System.out.println(Yiran);
	}
}
