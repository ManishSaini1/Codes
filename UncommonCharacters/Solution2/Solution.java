
import java.util.HashSet;
import java.util.TreeSet;

public class Solution {

	public static String findUncommonCharacters(String s1, String s2) {
		// Set to store the uncommon characters of the two strings
		HashSet<Character> uncommonChars = new HashSet<>();

		// Variable to check if the character is present in both the strings
		boolean isPresent = false;

		// Finding the uncommon characters that are present in string s1, but not in s2
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				// Character is present in both s1 and s2
				if (s1.charAt(i) == s2.charAt(j)) {
					isPresent = true;
					break;
				}
			}

			// Character is not present in s2
			if (isPresent == false) {
				uncommonChars.add(s1.charAt(i));
			} else {
				isPresent = false;
			}
		}

		isPresent = false;

		// Finding the uncommon characters that are present in string s2, but not in s1
		for (int i = 0; i < s2.length(); i++) {
			for (int j = 0; j < s1.length(); j++) {
				// Character is present in both s1 and s2
				if (s2.charAt(i) == s1.charAt(j)) {
					isPresent = true;
					break;
				}
			}

			// Character is not present in s1
			if (isPresent == false) {
				uncommonChars.add(s2.charAt(i));
			} else {
				isPresent = false;
			}
		}

		String ans = "";
		  // Sorting HashSet using TreeSet 
		TreeSet<Character> treeSet = new TreeSet<Character>(uncommonChars);
		for (char ch : treeSet) {
			ans += ch;
		}
		return ans;
	}

}
