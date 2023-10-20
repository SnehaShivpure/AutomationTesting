package ActitimeTask;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.SeleniumUtil;

public class Actitime {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=SeleniumUtil.setUp("chrome", "https://demo.actitime.com/login.do");		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		Actions action=new Actions(driver);
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		
		driver.findElement(By.cssSelector(".tasks")).click();
		//open new task page
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.cssSelector(".createNewTasks")).click();
		Thread.sleep(2000);
		//select customer
		driver.findElement(By.cssSelector(".customerSelector>div>.comboboxButton>.selectedItem")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".customerSelector .searchItemList")));
		
		List<WebElement> customerList=driver.findElements(By.cssSelector(".customerSelector .searchItemList>div"));
		
		if(customerList.size()>2) {
			customerList.get(customerList.size()-1).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".projectSelector>div>.comboboxButton>.selectedItem")).click();
			Thread.sleep(1000);
			List<WebElement> projectList=driver.findElements(By.cssSelector(".projectSelector .searchItemList>div"));
			if(projectList.size()>3) {
				projectList.get(3).click();
			}else {
				projectList.get(0).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".selectProjectRow .newProject")).sendKeys("iPhone 15");
			}			
		}else {
			customerList.get(0).click();
			Thread.sleep(2000);
			List<WebElement> newInputFields=driver.findElements(By.cssSelector(".newCustomerProjectField "));
			newInputFields.get(0).sendKeys("Apple");
			newInputFields.get(1).sendKeys("iPhone 15");
		}
		Thread.sleep(1000);
		List<WebElement> taskList=driver.findElements(By.cssSelector("#createTasksPopup_content .createTasksTable input[placeholder='Enter task name']"));
		taskList.get(0).sendKeys("Testing");
		Thread.sleep(1000);		
		WebElement createTaskButton=driver.findElement(By.xpath("//div[@id='createTasksPopup']/div/div[@class='basicLightboxFooter']/div[@class='buttonsBox']/div/div/div[1]"));
		action.moveToElement(createTaskButton).doubleClick().build().perform();
	}


}
