public class Clock {
	
	private static int s;
	
	public static void setTime(int y) {
		s=y;
	}
	
	public static void tick()
	{
		s++;
	}
	
	public static void displayTime()
	{
		System.out.println(s%60);
	}
	// create your methods here
	
	public static void main(String[] args) {
		Clock tester = new Clock();
		
		// should display the time to be 56, 57, 58, 59, 0, 1, etc.
		tester.setTime(56);
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
	}
}