package Class;

public class WordlessBot extends ChatBot{

	
	@Override
	public void sayHi() {
		System.out.println( "You know what, I dont want to talk to you");
	}
	
	@Override
	public void sayBye() {
		System.out.println( "...Ahhh I gotta go");
	}
	
	@Override
	public void startConversation() {
		System.out.println( "Umm.....");
	}
	
	@Override
	public void askSecondQuestion() {
		System.out.println( "ahhh...");
	}
	
	@Override
	public void askFirstQuestion() {
		System.out.println( "emmmm....");
	}
	
	@Override
	public void askThirdQuestion() {
		System.out.println( "ughh....");
	}
}
