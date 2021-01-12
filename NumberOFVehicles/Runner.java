import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int tc, dig1, dig2, dig3, dig4, n;
		char ch1, ch2, ch3, ch4;
		tc = s.nextInt();
		while (tc-- > 0) {
			n = s.nextInt();
			ch1 = s.next().charAt(0);
			ch2 = s.next().charAt(0);
			ch3 = s.next().charAt(0);
			ch4 = s.next().charAt(0);
			dig1 = s.nextInt();
			dig2 = s.nextInt();
			dig3 = s.nextInt();
			dig4 = s.nextInt();
			int sol = Solution.numberOfVehicles(n, ch1, ch2, ch3, ch4, dig1, dig2, dig3, dig4);
			System.out.println(sol);
		}
	}

}
