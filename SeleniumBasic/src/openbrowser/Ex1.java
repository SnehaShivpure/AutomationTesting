package openbrowser;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Ex1 {
		public static void main(String[] args) {
			WebDriver driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			System.out.println("title: "+driver.getTitle());
			String actualTitle=driver.getTitle();
			System.out.println("Length of the Title:"+actualTitle.length());
			System.out.println("current url: "+driver.getCurrentUrl());
			String currentUrl=driver.getCurrentUrl();
			System.out.println("Length of the url:"+currentUrl.length());
			String expectedTitle="OrangeHRM";
			System.out.println("is orangehrmlive page opened? "+actualTitle.equals(expectedTitle));
			String expectedUrl=driver.getCurrentUrl();
			System.out.println("Is same expectedUrl and CurrentUrl:"+currentUrl.equals(expectedUrl));
			driver.close();

		}

	}


