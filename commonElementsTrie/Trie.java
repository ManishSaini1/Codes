/*
    Time Complexity : O(K * S)
    Space Complexity :  O(26 * N * S)

    where K = max(N, M), S is the average size of the strings and N is the size of the first array
*/

import java.util.ArrayList;

class TrieNode {

	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	int count;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		count = 0;
		children = new TrieNode[26];
		childCount = 0;
	}
}

public class Trie {
	private TrieNode root;
	public int count;

	public Trie() {
		root = new TrieNode('\0');
	} // Function to insert a string in the trie

	void insert(String word) {
		TrieNode temp = root;

		for (int i = 0; i < word.length(); i++) {
			if (temp.children[word.charAt(i) - 'a'] == null) {
				temp.children[word.charAt(i) - 'a'] = new TrieNode('\0');
			}
			temp = temp.children[word.charAt(i) - 'a'];
		}

		// Increment the count
		temp.count++;
	}

	// Returns true if the string is present in the trie
	boolean searchAndErase(String word) {
		TrieNode temp = root;

		for (int i = 0; i < word.length(); i++) {
			if (temp.children[word.charAt(i) - 'a'] == null) {
				return false;
			}
			temp = temp.children[word.charAt(i) - 'a'];
		}

		// If it is the last node and the count is greater than 0
		if (temp.count > 0) {
			temp.count--;
			return true;
		}
		return false;
	}

	public static ArrayList<String> findCommonElements(String[] arr1, String[] arr2, int n, int m) {
		// ArrayList to store the common elements of both the arrays
		Trie root = new Trie();
		ArrayList<String> commonElements = new ArrayList<>();
		for (int i = 0; i < arr1.length; i++) {
			root.insert(arr1[i]);
		}

		for (int i = 0; i < m; i++) {
			String s = arr2[i];

			// If the trie contains the string, it is present in both the arrays
			if (root.searchAndErase(s) == true) {
//				System.out.println("Adding Element to Array List");
				commonElements.add(s);
			}
		}

		// Return the answer
		return commonElements;
	}

}
