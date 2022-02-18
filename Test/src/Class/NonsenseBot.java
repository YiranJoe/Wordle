package Class;

public class NonsenseBot extends ChatBot{

	@Override
	public void sayHi() {
		System.out.println( "A BA A BA A BA");
	}
	
	@Override
	public void sayBye() {
		System.out.println( "See U LALA.");
	}
	
	@Override
	public void startConversation() {
		System.out.println( "Nonsense is best,Best,BEST");
	}
	
	@Override
	public void askSecondQuestion() {
		System.out.println( "Does You love being logic?? NAHHHHH");
	}
	
	@Override
	public void askFirstQuestion() {
		System.out.println( "Does yoU like NONSENSE???");
	}
	
	@Override
	public void askThirdQuestion() {
		System.out.println( "THE OTHER 2 ROBOTS SUCK,RIGHT??");
	}
}
