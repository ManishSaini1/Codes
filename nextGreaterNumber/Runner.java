import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int t = s.nextInt();
		while (t-- > 0) {
			String str = s.next();
			String ans = Solution.nextGreater(str);
			System.out.println(ans);
		}
	}

}
