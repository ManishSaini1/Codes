/*
Time Complexity : O(K * S)
Space Complexity :  O(N)

where K = max(N, M), S is the average size of the strings and N is the size of the first array
*/
import java.util.ArrayList;
import java.util.HashMap;
public class Trie {
	public static ArrayList<String> findCommonElements(String arr1[], String arr2[], int n, int m) {
		// ArrayList to store the common elements of both the arrays
		ArrayList<String> commonElements = new ArrayList<>();

		// Hashmap to store the count of strings
		HashMap<String, Integer> countOfElements = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String s = arr1[i];
			if (countOfElements.containsKey(s)) {
				countOfElements.put(s, countOfElements.get(s) + 1);
			} else {
				countOfElements.put(s, 1);
			}
		}

		for (int i = 0; i < m; i++) {
			String s = arr2[i];

			// If the string is present in both the arrays
			if (countOfElements.containsKey(s) && countOfElements.get(s) > 0) {
				commonElements.add(s);
				countOfElements.put(s, countOfElements.get(s) - 1);

				// If the count of the string becomes 0, delete it from the hashmap
				if (countOfElements.containsKey(s) && countOfElements.get(s) == 0) {
					countOfElements.remove(s);
				}
			}
		}

		// Return the answer
		return commonElements;
	}

}
