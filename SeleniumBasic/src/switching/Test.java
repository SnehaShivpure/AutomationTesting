package switching;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

    public class sortablePage {
	private WebDriver driver;
    private SortablePage sortablePage;

    @BeforeTest
    public void setupDriver() {
        this.driver = new ChromeDriver();
        this.sortablePage = new SortablePage(driver);
    }

    @Test(dataProvider = "number-inputs")
    public void intMove(int fromIndex, int toIndex, List<String> expectedOrder) {
        sortablePage.goTo();
        sortablePage.getSortables().reorder(fromIndex, toIndex);
        Assert.assertEquals(expectedOrder, sortablePage.getSortables().getItems());
    }

    @Test(dataProvider = "string-inputs")
    public void stringMove(String fromItem, String toItem, List<String> expectedOrder) {
        sortablePage.goTo();
        sortablePage.getSortables().reorder(fromItem, toItem);
        Assert.assertEquals(expectedOrder, sortablePage.getSortables().getItems());
    }

    @DataProvider(name = "number-inputs")
    public static Object[][] getNumberInputs() {
        return new Object[][]
        {
            {
                0
                2
                Arrays.asList("Item 2", "Item 3", "Item 1", "Item 4", "Item 5", "Item 6", "Item 7")
            },
            {
                1
                3
                Arrays.asList("Item 1", "Item 3", "Item 4", "Item 2", "Item 5", "Item 6", "Item 7")
            }
        };
    }

    

}
