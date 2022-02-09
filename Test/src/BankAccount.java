
public class BankAccount {
	
	private String userName;
	private double money;

	public BankAccount(String userName,double money) {
		this.userName=userName;
		this.money=money;
	}
	
	public BankAccount(String userName) {
		this.userName=userName;
		money=0;
	}
	
	public double getMoney() {
		return money;
	}
	
	public String getName() {
		return userName;
	}
	
	public void deposit(double n) {
		money+=n;
	}
	
	public void withDraw(double n) {
		money-=n;
	}
	
	public void display() {
		System.out.println("there are "+money+" dollars in "+userName+"'s account");
	}
	
	public String toString() {
		return userName+"'s account has "+money+" dollars.";
	}
	
	public static void main(String[] args) {
		BankAccount Yiran=new BankAccount("Yiran",10);

		Yiran.deposit(10);
		Yiran.withDraw(15);
		Yiran.display();
	}
}
