package MyTestCase;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp {

	WebDriver driver = new ChromeDriver();

	Random rand = new Random();

	String URL = "https://magento.softwaretestingboard.com/customer/account/create/";
	String FirstName = "Shahed";
	String lastName = "Saqlawi";
	String Email = "Shahed";
	String Domain = "@gmail.com";
	String Password = "Shahed23!@#";

	@BeforeTest
	public void mySetup() {
		driver.get(URL);

	}
	//invocationCount = 10 ==>repeat
	@Test()
	public void myTest() {

		int myNewIDForTheEmail = rand.nextInt(10000);
		// define all the webelement that will be used
		WebElement FirstNameInputField = driver.findElement(By.id("firstname"));
		WebElement LastNameInputField = driver.findElement(By.id("lastname"));
		WebElement EmailInputField = driver.findElement(By.id("email_address"));
		WebElement PasswordInputField = driver.findElement(By.id("password"));
		WebElement PasswordConfirmationField = driver.findElement(By.id("password-confirmation"));
		WebElement SignUpButton = driver.findElement(By.className("submit"));

		// interact with webelements
		FirstNameInputField.sendKeys(FirstName);
		LastNameInputField.sendKeys(lastName);
		EmailInputField.sendKeys(Email + myNewIDForTheEmail + Domain);
		PasswordInputField.sendKeys(Password);
		PasswordConfirmationField.sendKeys(Password);
		SignUpButton.click();
	}

	@AfterTest
	public void myAfter() {
	}

}