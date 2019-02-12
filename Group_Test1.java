package klm;

import org.testng.annotations.*;

public class Group_Test1 {
	@Test(groups="G1")
	public void meth1()
	{
		System.out.println("b1");
	}
	@Test(groups="A1")
	public void meth2()
	{
		System.out.println("b2");
	}
	@Test(groups="G1")
	public void meth3()
	{
		System.out.println("b3");
	}
	@Test(groups="A1")
	public void meth4()
	{
		System.out.println("b4");
	}
	@Test(groups="g1")
	public void meth5()
	{
		System.out.println("b5");
	}

}
