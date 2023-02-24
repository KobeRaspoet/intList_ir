package intList_ir;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class intListTest {

	@Test
	void test() {
		int[] test = new int[] {1,2,3,4,5};
		intList xs = new intList(test);
		
		assertArrayEquals(
				new int[] {1,2,3,4,5}, xs.toIntArray()
				);
		assertEquals(5, xs.length());
		assertEquals(2, xs.intAt(1));
		
		int[] cs = xs.toIntArray();
		cs[1] = 5;
		assertEquals(5, xs.length());
		assertEquals(2, xs.intAt(1));
		
		test[1] = 5;
		assertEquals(5, xs.length());
		assertEquals(2, xs.intAt(1));
		
		xs.addInt(6);
		assertArrayEquals(
				new int[] {1,2,3,4,5,6}, xs.toIntArray()
				);
		assertEquals(6, xs.length());
		
		xs.deleteLast();
		assertEquals(5, xs.length());
		assertArrayEquals(
				new int[] {1,2,3,4,5}, xs.toIntArray()
				);
		intList ys = new intList(new int[] {});
		assertArrayEquals(
				new int[] {}, ys.toIntArray()
				);
	}

}
