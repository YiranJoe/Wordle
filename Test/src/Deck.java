
public class Deck {

	private Card[] deck=new Card[52];
	
	public Deck() {
		int k=0;
		String[] suits= {"clubs","spades","diamonds","hearts"};
		for(int i=0;i<suits.length;i++) {
			for(int j=1;j<=13;j++) {
				deck[k]=new Card(j,suits[i]);
				k++;
			}
		}
	}
	
	public String toString() {
		String output="";
		for(Card c:deck) {
			output+=c.toString();
		}
		
		return output;
	}
	
	public Card getRandom() {
		return deck[(int)Math.random()*52+0];
	}
	
	public Card[] getFirstN(int n) {
		Card[] t=new Card[n];
		for(int i=0;i<n;i++) {
			t[i]=deck[i];
		}
		return t;
	}
	
	public void shuffle() {
		for(int i=0;i<52;i++) {
			Card temp=deck[i];
			int n=(int)(Math.random()*52+0);
			deck[i]=deck[n];
			deck[n]=temp;
		}
	}
	
	public void sort() {
		for(int i=0;i<52;i++) {
			int min=deck.length-1;
			for(int j=i;j<51;j++) {
				if(deck[j].getNum()<deck[min].getNum()) {
					min=j;
				}
			}
			Card temp=deck[min];
			deck[min]=deck[i];
			deck[i]=temp;
		}
	}
	
}
