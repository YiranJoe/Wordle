
public class GreatAccount extends BankAccount{

	public int withDrawCount;
	public int MonthsCount;
	public int totalWithDraw;
	public GreatAccount(String userName,double money) {
		super(userName,money);
		withDrawCount=0;
		MonthsCount=0;
	}
	
	
	public void withDraw(double money) {
		if(withDrawCount<3) {
			super.withDraw(money);
			totalWithDraw++;
			withDrawCount++;
		}else{
			System.out.println(getName()+" has already withdraw 3 times!");
		}
	}
	
	public void nextMonth() {
		withDrawCount=0;
		MonthsCount++;
		if(MonthsCount==12&&totalWithDraw==0) {
			super.deposit(getMoney()*2);
			MonthsCount=0;
		}
		if(MonthsCount==12) {
			totalWithDraw=0;
		}
	}
	
	public String toString() {
		return super.toString()+" " + withDrawCount+ " times of withdraws. "+MonthsCount+" months";
	}
	
	public static void main(String[] args) {
		GreatAccount Yiran=new GreatAccount("Yiran",1000);
		GreatAccount Condy=new GreatAccount("Condy",1000);
		Condy.withDraw(100);
		Condy.withDraw(100);
		Condy.withDraw(100);
		Condy.withDraw(100);
		System.out.println(Condy);
		Condy.nextMonth();
		System.out.println(Condy);
		
		Yiran.nextMonth();
		Yiran.nextMonth();
		Yiran.nextMonth();
		Yiran.nextMonth();
		Yiran.nextMonth();
		Yiran.nextMonth();
		Yiran.nextMonth();
		Yiran.nextMonth();
		Yiran.nextMonth();
		Yiran.nextMonth();
		Yiran.nextMonth();
		Yiran.nextMonth();
		System.out.println(Yiran);
	}
	
}
