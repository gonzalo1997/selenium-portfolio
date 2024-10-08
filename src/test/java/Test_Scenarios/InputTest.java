package Test_Scenarios;

import Pages.InputPage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

class InputTest {
	static WebDriver driver;
	
	@BeforeAll
	static public void SetUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		driver.get("https://testpages.eviltester.com/styled/validation/input-validation.html");
		
	}
	
	@Test
	public void TestInputSubmit() {
		InputPage page = new InputPage(driver);
		page.setFirstName("Hello");
		page.setLastName("ByeByeeeeee");
		page.setAge("18");
		page.setCountry("Argentina");
		page.setNotes("An example note");
		page.submit();
		
		assertEquals(page.GetInputMessage(), "Your Input passed validation");
	}
	
	@AfterAll
	static public void TearDown() {
		driver.quit();
	}

}
