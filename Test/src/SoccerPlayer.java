
public class SoccerPlayer extends Athletes {

	private int totalGoals;
	public SoccerPlayer(int age, int strength, int speed, String name, int totalGoals) {
		super(age,strength,speed,name);
		this.totalGoals=totalGoals;
	}
	
	public void Goal() {
		totalGoals++;
	}
	
	public void train(int workLoad){
		super.setSpeed(getSpeed()+workLoad);
	}
	
	public String toString() {
		return getName()+" is "+getAge()+" and he has a strength of "+getStrength()+" and a speed of "+getSpeed()+", and scored "+totalGoals+" goals this season.";
	}
	
	public static void main(String[] args) {
		SoccerPlayer a=new SoccerPlayer(16,55,108,"Yiran",0);
		a.train(5);
		a.Goal();
		System.out.print(a);
	}
}
