
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		while (tc-- > 0) {

			String S;
			S = s.next();

			String sol = Solution.nextSmallerPalindrome(S);
			System.out.println(sol);
		}
	}

}
