
import java.util.ArrayList;
import java.util.Scanner;

class Pair {
	int first;
	long second;

	Pair() {
	}

	Pair(int first, long second) {
		this.first = first;
		this.second = second;
	}
}

public class Runner {
	static Scanner s = new Scanner(System.in);
	static ArrayList<Pair> genChild = new ArrayList<>();
	static int t;

	public static void takeInput() {
		t = s.nextInt();

		for (int c = 0; c < t; c++) {
			int n = s.nextInt();
			long k = s.nextLong();
			Pair p = new Pair(n, k);
			genChild.add(p);
		}
	}

	public static void executeAndPrintOutput() {
		for (int i = 0; i < t; i++) {
			String ans = Solution.kthChildNthGeneration(genChild.get(i).first, genChild.get(i).second);
			System.out.println(ans);
		}
	}

	public static void main(String[] args) {
		takeInput();
		executeAndPrintOutput();
	}
}
