import java.util.Scanner;

class ListNode<t> {
	public t data;
	public ListNode<t> next;

	public ListNode(t data) {
		this.data = data;
	}
}

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static ListNode<Integer> createlist() {

		ListNode<Integer> head = null;
		ListNode<Integer> rear = null;
		int data = s.nextInt();
		while (data != -1) {
			ListNode<Integer> newnode = new ListNode<Integer>(data);
			if (head == null) {
				head = newnode;
				rear = head;
			} else {
				rear.next = newnode;
				rear = rear.next;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static void print(ListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.print("-1");
	}

	public static void main(String[] args) {
		int testCases = s.nextInt();
		while (testCases > 0) {
			ListNode<Integer> head1 = createlist();
			ListNode<Integer> head2 = createlist();
			ListNode<Integer> head = Solution.addTwoLists(head1, head2);
			print(head);
			System.out.println();
			testCases--;
		}
	}

}
