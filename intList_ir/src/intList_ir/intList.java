package intList_ir;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a sequence of integers.
 * 
 * @immutable
 */
public class intList {
	/**
	 * @representationObject
	 */
	private int[] integers;
	
	/**
	 * @inspects | this
	 * @post | result == toIntArray().length
	 */
	public int length() {
		return integers.length;
	}
	
	/**
	 * @pre | 0 <= index && index < this.length()
	 * @inspects | this
	 * @post | result == toIntArray()[index] 
	 */
	public int intAt(int index) {
		return integers[index];
	}
	
	/**
	 * @inspects | this
	 * @creates | result
	 * @post | result != null
	 */
	public int[] toIntArray() {
		return integers.clone();
	}
	
	/**
	 * @pre | numbers != null
	 * @mutates | this
	 * @post | Arrays.equals(toIntArray(), numbers)
	 */
	public intList(int[] numbers) {
		integers = numbers.clone();
	}
	
	/**
	 * @pre | 0<= number
	 * @mutates | this
	 * @post | this.length() == old(length())+1
	 * @post | number == intAt(length()-1)
	 * @post | IntStream.range(0, old(length())).allMatch(i -> intAt(i) == old(this).intAt(i))
	 */
	public void addInt(int number) {
		int[] temp = new int[this.length()+1];
		for (int i=0;i<length();i++)
			temp[i] = this.intAt(i);
		temp[this.length()] = number;
		this.integers = temp;
	}
	
	/**
	 * @mutates | this
	 * @post | this.length() == old(length())-1
	 * @post | IntStream.range(0, length()).allMatch(i -> intAt(i) == old(this).intAt(i))
	 */
	public void deleteLast() {
		int[] temp = new int[this.length()-1];
		for (int i=0;i<length()-1;i++)
			temp[i] = this.intAt(i);
		this.integers = temp;
	}
	
}
