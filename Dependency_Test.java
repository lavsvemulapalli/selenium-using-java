package klm;

import org.testng.annotations.*;

public class Dependency_Test {
	@Test
	public void meth1()
	{
		System.out.println("m1");
		int x=10/0;
	}
	@Test(dependsOnMethods="meth1")
	public void meth2()
	{
		System.out.println("m2");
	}

}
