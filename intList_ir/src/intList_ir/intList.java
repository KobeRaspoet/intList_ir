package intList_ir;

import java.util.stream.IntStream;

/**
 * Each instance of this class represents a sequence of integers.
 * 
 */
public class intList { 
	
	private static class Node{
		private int value;
		/**
		 * @peerObject
		 */
		private Node next;
		
		private Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	private boolean hasLength(Node n, int lengte) {
		return n == null && lengte == 0 || lengte > 0 && hasLength(n.next, lengte - 1);
	}
	
	/**
	 * @invar | hasLength(first, length)
	 * @representationObject
	 */
	private Node first;
	private int length;
	
	/**
	 * @inspects | this
	 * @post | result == toIntArray().length
	 */
	public int length() {
		return this.length;
	}
	
	/**
	 * @pre | 0 <= index && index < length()
	 * @inspects | this
	 * @post | result == toIntArray()[index] 
	 */
	public int intAt(int index) {
		Node n = first;
		for (int i=0;i<index;i++)
			n = n.next;
		return n.value;
	}
	
	/**
	 * 
	 * @creates | result
	 * @post | result != null
	 */
	public int[] toIntArray() {
		int[] result = new int[length];
		Node n = first;
		for (int i = 0; i < result.length; i++) {
			result[i] = n.value;
			n = n.next; 
		}
		return result;
	}
	
	/**
	 * @post | length() == 0
	 */
	public intList() {}
	
	/**
	 * @mutates | this
	 * @post | this.length() == old(length())+1
	 * @post | number == intAt(length()-1)
	 * @post | IntStream.range(0, old(length())).allMatch(i -> intAt(i) == old(this).intAt(i))
	 */
	public void addInt(int number) {
		if (first == null)
			first = new Node(number,null);
		else {
			Node n = first;
			while (n.next != null)
				n = n.next;
			n.next = new Node(number, null);
		}
		length++;
	}
	
	/**
	 * @pre | length() > 0
	 * @mutates | this
	 * @post | this.length() == old(length())-1
	 * @post | IntStream.range(0, length()).allMatch(i -> intAt(i) == old(this).intAt(i))
	 */
	public void deleteLast() {
		length--;
		if (first.next == null) {
			first = null;
		}
		else {
			Node n = first;
			while (n.next.next != null)
				n = n.next;
			n.next = null;
		}
			
	}
	
}
