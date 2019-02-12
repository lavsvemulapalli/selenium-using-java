package klm;

import org.junit.*;

public class JunitDemo {
	
	
	@BeforeClass
	public static void oneTimeSetUp()

	{
		System.out.println("@BeforeClass");
	}
	
	@AfterClass
	public static void oneTimeTearDown()

	{
		System.out.println("@AfterClass");
	}
	@Before
	public void setUp()

	{
		System.out.println("@Before");
	}
	
	@After
	public void tearDown()

	{
		System.out.println("@After");
	}
	
	@Test
	public void test1()
	{
		System.out.println("test1");
	}
	@Test
	public void test2()
	{
		System.out.println("test2");
	}
	
}
