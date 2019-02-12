package klm;

import org.testng.annotations.*;

public class Group_Test {
	@Test(groups="G1")
	public void meth1()
	{
		System.out.println("g1");
	}
	@Test(groups="A1")
	public void meth2()
	{
		System.out.println("g2");
	}
	@Test(groups="G1")
	public void meth3()
	{
		System.out.println("g3");
	}
	@Test(groups="A1")
	public void meth4()
	{
		System.out.println("g4");
	}
}
