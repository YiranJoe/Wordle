
public class Wrestler {

	private String name;
	private int weight;
	private String outfitColor;
	private int numOfWins;
	
	public Wrestler(String n,int w,String oC, int nOW) {
		name=n;
		weight=w;
		outfitColor=oC;
		numOfWins=nOW;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String getName() {
		return name;
	}
	
	public String intimidating() {
		return "[insert intimidating lines]";
	}
	
	
	public void Fight(Wrestler other) {
		boolean win=false;
		if(weight>other.getWeight()) {
			win=true;
		}else if(weight==other.getWeight()){
			for(int i=0;i<name.length();i++) {
				if(name.compareToIgnoreCase(other.name)<0) {
					win=true;
					break;
				}
			}
		}
		if(win==true) {
			System.out.print(name+" wins! ");
			numOfWins++;
		}else{
			System.out.print(other.getName()+" wins! ");
			other.numOfWins++;
		}
	}
	
	public void lift(double n) {
		weight+=n*0.01;
	}
	
	public void tagTeam(Wrestler[] allies, Wrestler[] enemies) {
		int totalAllyWeight=weight;
		int totalEnemyWeight=0;
		for(int i=0;i<allies.length;i++) {
			allies[i].outfitColor=outfitColor;
			totalAllyWeight+=allies[i].getWeight();
		}
		for(int j=0;j<enemies.length;j++) {
			enemies[j].outfitColor=enemies[0].outfitColor;
			totalEnemyWeight+=enemies[j].getWeight();
		}
		
		boolean win=false;
		if(totalAllyWeight>=totalEnemyWeight) {
			win=true;
		}
		
		if(win==true) {
			System.out.print("allies win! ");
			for(int i=0;i<allies.length;i++) {
				allies[i].numOfWins++;
			}
		}else {
			System.out.print("enemies win.. ");
			for(int i=0;i<enemies.length;i++) {
				enemies[i].numOfWins++;
			}
		}
	}
	
	public static void main(String[] args) {
		Wrestler Condy= new Wrestler("Condy",10,"green",0);
		Wrestler Yiran= new Wrestler("Yiran",11,"green",0);
		Wrestler Cooper= new Wrestler("Cooper",12,"yellow",0);
		Wrestler David= new Wrestler("David",9,"red",0);
		Wrestler Jamie= new Wrestler("Jamie",5,"black",0);
		Wrestler Gregory= new Wrestler("Gregory",15,"blue",0);
		
		
		
		Condy.Fight(Yiran);
		Yiran.Fight(Condy);
		
		
		Yiran.tagTeam(new Wrestler[] {Jamie}, new Wrestler[] {Cooper,David,Gregory,Condy});
	}
	
}
