
public class InterestAccount extends BankAccount{

	private double interest;
	
	public InterestAccount(String userName,int money, double interest) {
		super(userName,money);
		this.interest=interest;
	}
	public double getInterest() {
		return interest;
	}
	
	public void addInterest() {
		super.deposit(getMoney()*interest);
	}
	
	public String toString() {
		return "the interest is: "+interest+", and the total money in "+super.getName()+"'s account is "+super.getMoney();
	}
	
	public static void main(String[] args) {
		InterestAccount Yiran=new InterestAccount("Yiran",10,0.2);
		Yiran.addInterest();
		System.out.println(Yiran);
	}
}
