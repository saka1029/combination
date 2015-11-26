package puzzle.util;

import static org.junit.Assert.*;
import static puzzle.util.Cons.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

public class TestCons {

	@Test
	public void testCons() {
		assertEquals(list(1, 2, 3), cons(1, list(2, 3)));
		assertEquals(list(1, 2, 3), cons(1, cons(2, cons(3, nil()))));
		assertNotEquals(list(1, 2, 3), nil());
		assertEquals(nil(), nil());
		assertEquals(nil(), list());
		assertEquals(Arrays.asList(2, 3, 4), list(2, 3, 4).toList());
		assertEquals(list(5, 6, 7), list(Arrays.asList(5, 6, 7)));
		assertEquals(2, (int)list(1, 2, 3).get(1));
		assertEquals(3, list(1, 2, 3).size());
		assertEquals(Arrays.asList(2, 4),
			list(1, 2, 3, 4).stream()
				.filter(i -> i % 2 == 0)
				.collect(Collectors.toList()));
	}

}
