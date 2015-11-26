package stackoverflow;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestReplaceAll {

    @Test
    public void test() {
        System.out.println("001.23004".replaceAll("(?=^0*)0", " "));
        System.out.println("001.23004".replaceAll("\\G0", " "));
    }
    
    public enum Operator {
        Plus {
            @Override
            public int eval(int a, int b) { return a + b; }
        },
        Minus {
            @Override
            public int eval(int a, int b) { return a - b; }
        };
        public abstract int eval(int a, int b);
    }

    @Test
    public void testOperator() {
    	int a = 2, b = 3, c = 0;
    	Operator op = Operator.Plus;
    	// ...
    	c = op.eval(a, b);
    	switch (op) {
    	case Plus: c = a + b; break;
    	case Minus: c = a - b; break;
    	}
    	System.out.println("c=" + c);
    }
}
