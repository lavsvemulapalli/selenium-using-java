package klm;

import org.junit.*;

public class JunDemo {
	@Before
	public void setUp()
	{
		System.out.println("before");
	}

@After
public void tearDown()
{
	System.out.println("after");
}

@BeforeClass
 public static void oneTimeSetUp()
{
	System.out.println("before class");
}

@AfterClass
 public static void oneTimetearDowm()
{
	System.out.println("after class");

}
@Test
public void testSetup()
{

	System.out.println("test class");

}
@Test
public void testSetup1()
{

	System.out.println("test class1");

}
}