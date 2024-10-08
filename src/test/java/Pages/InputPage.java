package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputPage {
	private WebDriver driver;
	
	public InputPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By input_firstName = By.id("firstname");
	By input_lastName = By.id("surname");
	By input_age = By.id("age");
	By ddl_country = By.id("country");
	By txt_notes = By.id("notes");
	By btn_submit = By.xpath("/html/body/div/div[3]/form/input[4]");
	By txa_inputMsg = By.id("valid-input-value");
	
	public void setFirstName(String name) {
		driver.findElement(input_firstName).sendKeys(name);
		driver.findElement(input_firstName).sendKeys(Keys.TAB);
	}

	public void setLastName(String surname) {
		driver.findElement(input_lastName).sendKeys(surname);
	}
	
	public void setAge(String age) {
		driver.findElement(input_age).sendKeys(age);
	}
	
	public void setCountry(String country) {
		driver.findElement(ddl_country).sendKeys(country);
	}
	
	public void setNotes(String note) {
		driver.findElement(txt_notes).sendKeys(note);
	}
	
	public void submit() {
		driver.findElement(btn_submit).click();
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(txa_inputMsg));
	}
	
	public String GetInputMessage() {
		return driver.findElement(txa_inputMsg).getText();
	}
}
