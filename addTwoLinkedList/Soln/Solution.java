
/*
Time Complexity - O(N + M)
Space Complexity - O(1)

where N and M are the number of nodes in both lists respectively.
*/
public class Solution {

	public static ListNode<Integer> addTwoLists(ListNode<Integer> first, ListNode<Integer> second) {
		// Reverse both lists for simplicity
		first = reverseList(first);
		second = reverseList(second);

		// For simplicity, assign list with more digits to first list
		if (countDigits(first) < countDigits(second)) {
			ListNode<Integer> temp = first;
			first = second;
			second = temp;
		}

		int carry = 0;
		ListNode<Integer> head = first;

		while (second != null) {
			first.data += second.data + carry;
			carry = first.data / 10;
			first.data %= 10;

			// If the list ends but a carry remains
			if (first.next == null && carry > 0) {
				ListNode<Integer> newNode = new ListNode<Integer>(carry);
				first.next = newNode;

				first = first.next;
				carry = 0;
				break;
			}

			first = first.next;
			second = second.next;
		}

		// If there are more digits left to process in first list
		while (first != null) {
			first.data += carry;
			carry = first.data / 10;
			first.data %= 10;

			// If the list ends but a carry remains
			if (first.next == null && carry > 0) {
				ListNode<Integer> newNode = new ListNode<Integer>(carry);
				first.next = newNode;
				break;
			}

			first = first.next;
		}

		// Reverse to get the final number
		head = reverseList(head);

		return head;
	}

	public static ListNode<Integer> reverseList(ListNode<Integer> head) {
		ListNode<Integer> prev = null, curr = head, nextNode;

		while (curr != null) {
			nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}

		return prev;
	}

	public static int countDigits(ListNode<Integer> head) {
		int c = 0;

		while (head != null) {
			head = head.next;
			c++;
		}

		return c;
	}

}
