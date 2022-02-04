
public class SoccerGame{

	public static void main(String[] args) {
		Athletes Yiran=new Athletes(16,100,100,"Yiran");
		Yiran.train(5);
		System.out.println(Yiran);
		SoccerPlayer 大卫=new SoccerPlayer(16,55,108,"大卫",0);//大卫is the Chinese translation of David Xie
		大卫.train(10);
		大卫.Goal();
		System.out.println(大卫);
		Goalkeeper Greg=new Goalkeeper(15,3,3,"Gregory",0,1);
		Greg.Save();
		Greg.train(3);
		System.out.println(Greg);
	}
}
