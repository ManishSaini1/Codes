import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		String word = s.next();
		System.out.print(Solution.shortestSubstring(word));

	}

}
