package introUnit;

public class homework921 {
	public static void integerCharacter(int a) {
		System.out.println((char)a);
	}
	public static void numDigit(int b) {
		System.out.println(b % 10);
	}
	public static void numAverage(double c, double d) {
		System.out.println((c+ d) / 2);
	}
	public static void main(String[]args) {
		int x, y;
		double z1, z2;
		x = 97;
		y = 105;
		z1 = 2;
		z2 = 1;
		integerCharacter(x);
		numDigit(y);
		numAverage(z1, z2);
	}
}
