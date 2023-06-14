package homepage;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*BaseUrl:
https://demo.nopcommerce.com/
Requirement:
● Create the package homepage
e 1. create class "TopMenuTest"
1.1 create method with name "selectMenu" it has one parameter name "menu" of type  string
1.2 This method should click on the menu whatever name is passed as parameter. 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to  select the Menu and click on it and verify the page navigation. */


public class TopMenuTest extends BaseTest{
    String baseurl ="https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    @Test
    public void verifyPageNavigation(){
    selectMenu("Computers");//selectMenu to select the menu
    //verify page navigation
    String expectedTitle="Computers";
    String actualTitle=driver.findElement(By.xpath("//div[@class='menu-toggle']")).getText();
    Assert.assertEquals(actualTitle,expectedTitle,"Incorrect page navigation");
    }
    public void selectMenu(String menu) {
        String xpath = "//ul[@class='top-menu notmobile']" + menu + "']";
        WebElement menuItem = driver.findElement(By.xpath(xpath));
        menuItem.click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}










