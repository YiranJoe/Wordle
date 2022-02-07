
public class Garage {

	private Car[] garage;
	
	public Garage(int numOfCars) {
		garage=new Car[numOfCars];
	}
	
	public void addCar(String name, int mileAge, int year, int i) {
		garage[i]=new Car(name, year, mileAge);
	}
	
	public void totalWorth() {
		int totalWorthNum=0;
		for(int i=0;i<garage.length;i++) {
			if(garage[i]!=null) {
				totalWorthNum+=garage[i].worth();
			}
		}
		System.out.println("It is totally "+totalWorthNum+" dollars");
	}
	
	public void averageMileAge() {
		double sum=0;
		double count=0;
		for(int i=0;i<garage.length;i++) {
			if(garage[i]!=null) {
				sum+=garage[i].getMileAge();
				count++;
			}
		}
		System.out.println(sum/count+" is the average Mile Age");
	}
	
	public void drive(int i, int distance) {
		if(garage[i]!=null) {
			garage[i].drive(distance);
		}
	}
	
	public void getEachMileAge() {
		for(int i=0;i<garage.length;i++) {
			if(garage[i]!=null) {
				System.out.println(garage[i].getMileAge());
			}
		}
	}
	
	
	public static void main(String[] args) {
		Garage g=new Garage(3);
		Garage f=new Garage(5);
		g.addCar("y",19,2008,0);
		g.addCar("i",766,2011,1);
		g.addCar("r",534,2004,2);
		
		f.addCar("f",19,2008,0);
		f.addCar("g",766,2011,1);
		f.addCar("h",534,2004,2);
		f.addCar("y",766,2011,3);
		f.addCar("k",534,2004,4);
		
		g.totalWorth();
		g.averageMileAge();
		g.getEachMileAge();
		g.drive(1, 55);
		g.getEachMileAge();
		
		f.totalWorth();
		f.averageMileAge();
		f.getEachMileAge();
		f.drive(1, 55);
		f.getEachMileAge();
	}
}
