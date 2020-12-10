
/*
Time complexity: O(q^2)

Space complexity: O(hashtableSize)

Where q denotes the number of queries,hashtableSize denotes the size of the hash table.
*/
import java.util.ArrayList;

public class HashSet {
	Object[] map;
	int factor;

	/** Initialize your data structure here. */
	public HashSet() {
		map = new Object[1000];
		factor = 1000;
	}

	public void add(int key) {
		int position = key % factor;
		if (map[position] == null) {
			map[position] = new ArrayList<Integer>(50);
		}
		ArrayList<Integer> judge = (ArrayList<Integer>) map[position];
		if (!judge.contains(key)) {
			judge.add(key);
		}
	}

	public int removeElement(int key) {
		int position = key % factor;
		if (map[position] == null) {
			return -1;
		}
		ArrayList<Integer> judge = (ArrayList<Integer>) map[position];
		Integer in = key;
		if (judge.remove(in)) {
			return key;
		} else {
			return -1;
		}
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int position = key % factor;
		if (map[position] == null) {
			return false;
		}
		ArrayList<Integer> judge = (ArrayList<Integer>) map[position];
		return judge.contains(key);
	}

}
