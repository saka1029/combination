package combination;

import static org.junit.Assert.*;

import org.junit.Test;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class TestComp {

	@Test
	public void test() {
		Integer[] elements = { 1, 1, 2, 3};
		ICombinatoricsVector<Integer> initialVector = Factory.createVector(elements);
		for (int i = 1; i <= elements.length; ++i)
			for (ICombinatoricsVector<Integer> e : Factory.createSimpleCombinationGenerator(initialVector, i))
                System.out.println(e);
	}

}
