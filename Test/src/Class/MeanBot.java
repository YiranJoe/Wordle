package Class;

public class MeanBot extends ChatBot{
	
	@Override
	public void sayHi() {
		System.out.println( "ahhhh look who is here.");
	}
	
	@Override
	public void sayBye() {
		System.out.println( "See ya, hope my life won't be a failure like you.");
	}
	
	@Override
	public void startConversation() {
		System.out.println( "I thought it would be a happier day today until I met you.");
	}
	
	@Override
	public void askSecondQuestion() {
		System.out.println( "ahhh I see...Were you the only loser of the squash game we had last week");
	}
	
	@Override
	public void askFirstQuestion() {
		System.out.println( "Were you the lowest score getter for the last project? That must be tough");
	}
	
	@Override
	public void askThirdQuestion() {
		System.out.println( "Woah amazing... Why I did I not see you in class today morning? Were you Sleeping OVER?");
	}
	
	
}
