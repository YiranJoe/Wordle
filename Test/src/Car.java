
public class Car {

	private int mileAge;
	private int year;
	private String name;
	
	public Car(String name, int year, int mileAge) {
		this.name=name;
		this.year=year;
		this.mileAge=mileAge;
	}
	
	public void drive(int distance) {
		mileAge+=distance;
	}
	
	public int worth() {
		return year-mileAge;
	}
	
	public int getMileAge() {
		return mileAge;
	}
}
