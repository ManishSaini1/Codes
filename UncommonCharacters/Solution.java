import java.util.Arrays;

public class Solution {

	public static String findUncommonCharacters(String s1, String s2) {

		// Hash table of size 26, initialized to 0
		int presenceOfChars[] = new int[26];
		Arrays.fill(presenceOfChars, 0);

		for (int i = 0; i < s1.length(); i++) {
			presenceOfChars[s1.charAt(i) - 'a'] = 1;
		}

		for (int i = 0; i < s2.length(); i++) {
			if (presenceOfChars[s2.charAt(i) - 'a'] == 1) {
				// Character is present in both the strings
				presenceOfChars[s2.charAt(i) - 'a'] = -1;
			} else if (presenceOfChars[s2.charAt(i) - 'a'] == 0) {
				// Character is present only in string 2
				presenceOfChars[s2.charAt(i) - 'a'] = 2;
			}
		}

		String ans = "";
		for (int i = 0; i < 26; i++) {
			// Character is present in either of the two strings
			if (presenceOfChars[i] == 1 || presenceOfChars[i] == 2) {
				ans += (char) ('a' + i);
			}
		}
		return ans;
	}
}
