
public class Human {

	private int age;
	private String name;
	private int height;
	private int weight;
	private int sizeOfShoes;
	private String eyeColor;
	private boolean hair;
	
	public Human(int age,String n,int height,int weight,int sizeOfShoes, String eC, boolean hair) {
		
		this.age=age;
		name=n;
		this.height=height;
		this.weight=weight;
		this.sizeOfShoes=sizeOfShoes;
		eyeColor=eC;
		this.hair=hair;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int newAge) {
		age=newAge;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int newHeight) {
		height=newHeight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int newWeight) {
		weight=newWeight;
	}
	
	public int getSizeOfShoes() {
		return sizeOfShoes;
	}
	
	public void setSizeOfShoes(int newSizeOfShoes) {
		sizeOfShoes=newSizeOfShoes;
	}
	
	public void getOld() {
		age++;
	}
	
	public void changeName(String newName) {
		name=newName;
	}
	
	public void canVote(int year) {
		if(year%4==0&&age>=18) {
			System.out.print("Can vote");
		}else {
			System.out.print("Can't vote");
		}
	}
	
	public boolean getHair() {
		return hair;
	}
	
	public void setHair(boolean newHair) {
		hair=newHair;
	}
	
	public String toString() {
		return "I am "+name+", I am "+age+" years old, I am "+height+" feet tall and "+weight+" kg. "+"My shoes size is "+sizeOfShoes+ " and I have "+eyeColor+" eyes. I "+hair+" have hair";
	}
	
	public static void main(String[] args) {
		Human condy=new Human(13,"Condy",6,65,11,"blue",true);
		
		
		System.out.println(condy);
		
		condy.canVote(2012);
	}
	
}
