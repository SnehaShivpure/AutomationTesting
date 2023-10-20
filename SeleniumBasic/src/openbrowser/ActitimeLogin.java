package openbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActitimeLogin {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		/* findElement(By)-
		 * 		- this method will help us to locate/identify the element from the application
		 * 		- this method take "By" class as an parameter, where "By" class is a predefined class which has 
		 *        several static method known as locator in selenium-
		 *      		id(String),name(String),linkText(String),partialLinkText(String)
		 *      		className(String),tagName(String),cssSelector(String),xpath(String)
		 *      - this method returns WebElement
		 *  WebElement element=driver.findElement(By.id(""));
		 *  
		 *  once you get a WebElement, now you can perform any required action on it, like-
		 *  	for typing use-
		 *  			element.sendKeys("text");
		 *      for click operation-
		 *      		element.click();
		 *      for deleting existing text-
		 *      		element.clear();
		 */
//		WebElement userNameInputField=driver.findElement(By.id("username"));
//		userNameInputField.sendKeys("admin");
		
//		WebElement passwordInputField=driver.findElement(By.name("pwd"));
//		passwordInputField.sendKeys("manager");

//		WebElement loginButton=driver.findElement(By.id("loginButton"));
//		loginButton.click();
				//or
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
	}
}
/*
Open chrome browser
enter application URL
enter username as admin
enter password as manager
click on login button
*/
