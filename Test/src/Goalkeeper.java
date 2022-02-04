
public class Goalkeeper extends SoccerPlayer{

	private int savedGoals;
	
	public Goalkeeper(int age, int strength, int speed, String name, int totalGoals, int savedGoals) {
		super(age,strength,speed,name,totalGoals);
		this.savedGoals=savedGoals;
	}
	
	public void Save() {
		savedGoals++;
	}
	
	public void train(int workLoad) {
		setStrength(getStrength()+workLoad);
	}
	
	public String toString() {
		return getName()+" has saved "+savedGoals+" goals this season. His strength is "+getStrength()+"!";
	}
	
	public static void main(String[] args) {
		Goalkeeper Greg=new Goalkeeper(15,3,3,"Gregory",0,0);
		Greg.Save();
		Greg.train(3);
		System.out.print(Greg);
	}
}
