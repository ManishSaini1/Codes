
import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t > 0) {
			int x = s.nextInt(), y = s.nextInt();
			long n = s.nextLong();
			System.out.println(Solution.fibonacci(x, y, n));
			t--;
		}

	}

}
