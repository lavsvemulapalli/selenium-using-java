

	package klm;

	import org.testng.annotations.*;

	public class TN {

		@BeforeClass
		public void method1()
		{
			System.out.println("@BeforeClass");
			
		}
		@AfterClass
		public void method2()
		{
			System.out.println("@AfterClass");
			
		}
		@BeforeTest
		public void method3()
		{
			System.out.println("@BeforeTest");
			
		}
		@AfterTest
		public void method4()
		{
			System.out.println("@AfterTest");
			
		}
		
		@BeforeMethod
		public void method5()
		{
			System.out.println("@BeforeMethod");
			
		}
		
		@AfterMethod
		public void method6()
		{
			System.out.println("@AfterMethod");
			
		}
		
		@BeforeSuite
		public void method7()
		{
			System.out.println("@Beforesuite");
			
		}
		@AfterSuite
		public void method8()
		{
			System.out.println("@AfterSuite");
			
		}
		
		@Test
		public void method9()
		{
			System.out.println("@test1");
			
		}
		@Test
		public void method10()
		{
			System.out.println("@test2");
			
		}
		

}
