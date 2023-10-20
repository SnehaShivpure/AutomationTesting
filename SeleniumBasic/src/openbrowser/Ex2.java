package openbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex2 {
public static void main(String[] args) {
		
		//ChromeDriver cdriver=new ChromeDriver();
				//or
		WebDriver driver=new ChromeDriver();
		//enter application url
		driver.get("https://www.google.com");
		//get current title from application
		String actualTitle=driver.getTitle();
		String expectedTitle="Google";
		System.out.println("is google search page opened? "+actualTitle.equals(expectedTitle));
		//close browser
		driver.close();
	}

}
