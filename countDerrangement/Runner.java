import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-- > 0) {
			long n = s.nextLong();
			System.out.println(Solution.countDerangements(n));
		}

	}

}
