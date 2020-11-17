
/*
Time Complexity : O(N * M)
Space Complexity :  O(K)

where N and M are the sizes of both the arrays and K = min(N, M)
*/
import java.util.ArrayList;

public class Trie {
	public static ArrayList<String> findCommonElements(String arr1[], String arr2[], int n, int m) {
		// ArrayList to store the common elements of both the arrays
		ArrayList<String> commonElements = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			String s2 = arr2[i];

			for (int j = 0; j < n; j++) {
				String s1 = arr1[j];

				// If the string is present in both the arrays, it is a common element
				if (s1.equals(s2)) {
					// Add the string to the answer

					commonElements.add(s1);

					// Replace the string in the first array with an empty string
					arr1[j] = "";
					break;
				}
			}
		}

		// Return the answer
		return commonElements;
	}

}
