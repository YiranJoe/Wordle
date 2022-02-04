
public class Athletes {

	private int age;
	private int strength;
	private int speed;
	private String name;
	
	public Athletes(int age, int strength, int speed, String name) {
		this.age=age;
		this.strength=strength;
		this.speed=speed;
		this.name=name;
	}
	
	public void train(int workLoad) {
		strength+=workLoad;
		speed+=2*workLoad;
	}
	
	public void eat(int amountOfFood) {
		strength+=amountOfFood*2;
		speed-=amountOfFood;
	}
	
	public void seasonOver() {
		age++;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public String getName() {
		return name;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setSpeed(int newSpeed) {
		speed=newSpeed;
	}
	
	public void setStrength(int newStrength) {
		strength=newStrength;
	}
	
	
	public String toString() {
		return "The athletes is " + age + " years old. The strength of the athlete is "+ strength+" and his speed is "+speed+" and he is "+name;
	}
}
