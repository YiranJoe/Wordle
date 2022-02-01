
public class Card {

	private String suit;
	private int num;
	
	public Card(int n,String s) {
		suit=s;
		num=n;
	}
	
	public int getNum() {
		return num;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String toString() {
		return suit+" "+num+" ";
	}
}
