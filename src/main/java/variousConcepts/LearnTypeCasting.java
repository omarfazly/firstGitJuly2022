package variousConcepts;

import org.junit.Test;

public class LearnTypeCasting {

	@Test
	public void ma() {
	//Widening Casting
	
	int a = 5;
	double b = a;
	
	System.out.println(a);
	System.out.println(b);
	
	//Narrowing Casting
	
	double c = 7.5;
	int i = (int) c;
	
	System.out.println(c);
	System.out.println(i);
	
	}
	
}
