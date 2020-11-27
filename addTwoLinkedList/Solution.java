 /*
    Time Complexity - O(N + M)
    Space Complexity - O(N + M)

    where N and M are the number of nodes in both lists respectively.
*/
public class Solution {

	public static ListNode<Integer> addTwoLists(ListNode<Integer> first, ListNode<Integer> second) {

		// Reverse both lists for simplicity
		first = reverseList(first);
		second = reverseList(second);

		int carry = 0;
		ListNode<Integer> dummy = new ListNode<Integer>(-1);
		ListNode<Integer> curr = dummy;

		while (first != null && second != null) {
			ListNode<Integer> digit = new ListNode<Integer>((first.data + second.data + carry) % 10);
			carry = (first.data + second.data + carry) / 10;

			curr.next = digit;
			curr = curr.next;
			first = first.next;
			second = second.next;
		}

		while (first != null) {
			ListNode<Integer> digit = new ListNode<Integer>((first.data + carry) % 10);
			carry = (first.data + carry) / 10;

			curr.next = digit;
			curr = curr.next;
			first = first.next;
		}

		while (second != null) {
			ListNode<Integer> digit = new ListNode<Integer>((second.data + carry) % 10);
			carry = (second.data + carry) / 10;

			curr.next = digit;
			curr = curr.next;
			second = second.next;
		}

		// If some carry is left
		if (carry > 0) {
			ListNode<Integer> digit = new ListNode<Integer>(carry);
			curr.next = digit;
		}

		// Reverse to get the final number
		dummy = reverseList(dummy.next);

		return dummy;
	}

	public static ListNode<Integer> reverseList(ListNode<Integer> head) {
		ListNode<Integer> prev = null, curr = head, next;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

}
