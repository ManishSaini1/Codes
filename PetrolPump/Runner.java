 import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int petrol[] = new int[n];
		int distance[] = new int[n];

		for (int i = 0; i < n; i++) {
			petrol[i] = s.nextInt();
			distance[i] = s.nextInt();
		}
		System.out.println(Solution.firstCircularTour(petrol, distance, n));
	}
}
