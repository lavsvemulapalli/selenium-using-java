package klm;

import org.testng.annotations.*;

public class Priorty_Test {
	@Test
	public void meth1()
	{
	System.out.println("m1" );	
	}
	@Test(priority=5,enabled=false)
	public void meth2()
	{
	System.out.println("m2" );	
	}
	@Test(priority=4)
	public void meth3()
	{
	System.out.println("m3" );	
	}
	@Test(priority=3)
	public void meth4()
	{
	System.out.println("m4" );	
	}
	@Test(priority=2)
	public void meth5()
	{
	System.out.println("m5" );	
	}
	@Test(priority=1)
	public void meth6()
	{
	System.out.println("m6" );	
	}
}
