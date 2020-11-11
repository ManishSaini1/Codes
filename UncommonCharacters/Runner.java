
import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t > 0) {
			String s1 = s.next();
			String s2 = s.next();
			String ans = Solution.findUncommonCharacters(s1, s2);
			System.out.println(ans);
			t--;
		}
	}

}
