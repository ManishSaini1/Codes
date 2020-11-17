
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int n, m;
		while (t-- > 0) {
			n = s.nextInt();
			m = s.nextInt();
			String arr1[] = new String[n], arr2[] = new String[m];

			for (int i = 0; i < n; i++) {
				arr1[i] = s.next();
			}

			for (int i = 0; i < m; i++) {
				arr2[i] = s.next();
			}

			ArrayList<String> ans = Trie.findCommonElements(arr1, arr2, n, m);

			for (int i = 0; i < ans.size(); i++) {
				System.out.print(ans.get(i) + " ");
			}
			System.out.println();
		}

	}
}
