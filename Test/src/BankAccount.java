
public class BankAccount {
	
	private String userName;
	private int money;
	private double interestRate;

	public BankAccount(String userName,int money, double interestRate) {
		this.userName=userName;
		this.money=money;
		this.interestRate=interestRate;
	}
	
	public int getMoney() {
		return money;
	}
	
	public BankAccount(String userName,double interestRate) {
		this.userName=userName;
		this.interestRate=interestRate;
	}
	
	public void deposit(int n) {
		money+=n;
	}
	
	public void withDraw(int n) {
		money-=n;
	}
	
	public void addInterest() {
		money+=interestRate*money;
	}
	
	public String toString() {
		return userName+"'s account has "+money+" dollars.";
	}
	
	public static void main(String[] args) {
		BankAccount Yiran=new BankAccount("Yiran",10,0.1);
		Yiran.addInterest();
		Yiran.deposit(10);
		Yiran.withDraw(21);
		System.out.println(Yiran);
		BankAccount Condy=new BankAccount("Condy",0.1);
		Condy.deposit(10);
		Condy.addInterest();
		System.out.println(Condy);
	}
}
