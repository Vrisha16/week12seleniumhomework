package computer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*●BaseUrl:
https://demo.nopcommerce.com/
Requirement:
Create the package name computer
1. Create class “TestSuite”
Write the following Test:
1.Test name ()
1.1 Click on Computer Menu.
1.2 Click on Desktop
1.3 Select Sort By position "Name: Z to A"
1.4 Verify the Product will arrange in Descending order.*/
public class TestSuite extends BaseTest {
        String baseurl = "https://demo.nopcommerce.com";

        @Before
        public void setUp() {
                openBrowser(baseurl);
        }

        @Test
        public void Menu() {
                clickComputerMenu();
                clickDesktopSubMenu();
                selectSortBy("Name: Z to A");
                boolean isSortedDescending = verifyProductSorting();

        }

        public void clickComputerMenu() {
                WebElement computerMenu = driver.findElement(By.linkText("Computers"));
                computerMenu.click();
        }

        public void clickDesktopSubMenu() {
                WebElement desktopSubMenu = driver.findElement(By.linkText("Desktops"));
                desktopSubMenu.click();
        }

        public void selectSortBy(String sortBy) {
                WebElement sortByDropdown = driver.findElement(By.id("products-orderby"));
                sortByDropdown.sendKeys(sortBy);
        }

        public boolean verifyProductSorting() {
                WebElement productGrid = driver.findElement(By.className("product-grid"));
                String productsText = productGrid.getText();
                String[] productNames = productsText.split("\n");

                // Check if the product names are in descending order
                for (int i = 0; i < productNames.length - 1; i++) {
                        String currentProduct = productNames[i];
                        String nextProduct = productNames[i + 1];
                        if (currentProduct.compareToIgnoreCase(nextProduct) < 0) {
                                return false;
                        }
                }
                return true;
        }

        @Test
        public void verifyProductAddedToShoppingCartSuccessFully() {
                // 2.1 Click on Computer Menu.
                WebElement computerMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
                computerMenu.click();

                // 2.2 Click on Desktop
                WebElement desktopMenuItem = driver.findElement(By.xpath("//ul[@class='sublist']//a[contains(text(),'Desktops')]"));
                desktopMenuItem.click();

                // 2.3 Select Sort By position "Name: A to Z"
           //Select sortBySelect =new Select(driver.findElement(By.id("products-orderby")));
                //sortBySelect.selectByValue("5");

                // 2.4 Click on "Add To Cart"
                WebElement addToCartButton = driver.findElement(By.xpath("//input[@value='Add to cart']"));
                addToCartButton.click();

                // 2.5 Verify the Text "Build your own computer"
                WebElement productTitle = driver.findElement(By.xpath("//h1[@itemprop='name']"));
                String expectedProductTitle = "Build your own computer";
                Assert.assertEquals(productTitle.getText(), expectedProductTitle);

                // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
                //Select processorSelect = new Select(driver.findElement(By.id("product_attribute_1")));
                //processorSelect.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

                // 2.7.Select "8GB [+$60.00]" using Select class.
                //Select ramSelect =new Select(driver.findElement(By.id("product_attribute_2")));
                //ramSelect.selectByVisibleText("8GB [+$60.00]");

                // 2.8 Select HDD radio "400 GB [+$100.00]"
                WebElement hddRadio = driver.findElement(By.xpath("//input[@id='product_attribute_3_7']"));
                hddRadio.click();

                // 2.9 Select OS radio "Vista Premium [+$60.00]"
                WebElement osRadio = driver.findElement(By.xpath("//input[@id='product_attribute_4_9']"));
                osRadio.click();

                // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
                WebElement officeCheckBox = driver.findElement(By.xpath("//input[@id='product_attribute_5_10']"));
                WebElement commanderCheckBox = driver.findElement(By.xpath("//input[@id='product_attribute_5_12']"));
                officeCheckBox.click();
                commanderCheckBox.click();

                // 2.11 Verify the price "$1,475.00"
                WebElement priceLabel = driver.findElement(By.xpath("//span[@id='price-value-1']"));
                String expectedPrice = "$1,475.00";
                Assert.assertEquals(priceLabel.getText(), expectedPrice);

                // 2.12 Click on "ADD TO CART" Button.
                WebElement addToCartButton2 = driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']"));
                addToCartButton2.click();

                // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
                WebElement successMessage = driver.findElement(By.xpath("//div[@class='bar-notification success']"));
                String expectedSuccessMessage = "The product has been added to your shopping cart";
                Assert.assertTrue(successMessage.getText().contains(expectedSuccessMessage));

                // After that close the bar clicking on the cross button.
                WebElement closeButton = driver.findElement(By.xpath("//span[@class='close']"));
                closeButton.click();
                //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
                Actions actions = new Actions(driver);
                WebElement shoppingCartIcon = driver.findElement(By.xpath("//span[@class='cart-label']"));
                actions.moveToElement(shoppingCartIcon).perform();
                WebElement goToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
                goToCartButton.click();
                // 2.15 Verify the message "Shopping cart"
            WebElement shoppingCartMessage = driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
            String expectedShoppingCartMessage = "Shopping cart";
            Assert.assertEquals(shoppingCartMessage.getText(), expectedShoppingCartMessage);
            //2.16 Change the Qty to "2" and Click on "Update shopping cart"
            WebElement quantityInput = driver.findElement(By.xpath("//input[contains(@name,'itemquantity')]"));
            quantityInput.clear();
            quantityInput.sendKeys("2");
            WebElement updateCartButton = driver.findElement(By.xpath("//button[contains(@name,'updatecart')]"));
            updateCartButton.click();
            //2.17 Verify the Total"$2,950.00"
            WebElement totalLabel = driver.findElement(By.xpath("//span[@class='product-price']"));
            String expectedTotal = "$2,950.00";
            Assert.assertEquals(totalLabel.getText(), expectedTotal);
            //2.18 click on checkbox “I agree with the terms of service”
            WebElement agreeCheckbox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
            agreeCheckbox.click();
            //2.19 Click on “CHECKOUT”
            WebElement checkoutButton = driver.findElement(By.xpath("//button[contains(@id,'checkout')]"));
            checkoutButton.click();
            //2.20 Verify the Text “Welcome, Please Sign In!”
            WebElement welcomeMessage = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
            String expectedWelcomeMessage = "Welcome, Please Sign In!";
            Assert.assertEquals(welcomeMessage.getText(), expectedWelcomeMessage);
            //2.21Click on “CHECKOUT AS GUEST” Tab
            WebElement checkoutAsGuestTab = driver.findElement(By.xpath("//input[@class='button-1 checkout-as-guest-button']"));
            checkoutAsGuestTab.click();
            //2.22 Fill the all mandatory field
            WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
            firstNameInput.sendKeys("Jai");
            WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']"));
            lastNameInput.sendKeys("Patel");
            //2.23 Click on “CONTINUE”
            WebElement continueButton = driver.findElement(By.xpath("//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']"));
            continueButton.click();
            //2.24 Click on Radio Button “Next Day Air($0.00)”
            WebElement nextDayAirRadio = driver.findElement(By.xpath("//input[@id='shippingoption_1']"));
            nextDayAirRadio.click();
            //2.25 Click on “CONTINUE”
            continueButton = driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']//input[@class='button-1 shipping-method-next-step-button']"));
            continueButton.click();
            //2.26 Select Radio Button “Credit Card”
            WebElement creditCardRadio = driver.findElement(By.xpath("//input[@id='paymentmethod_1']"));
            creditCardRadio.click();
            //2.27 Select “Master card” From Select credit card dropdown
            //Select creditCardSelect = new Select(driver.findElement(By.xpath("//select[@id='CreditCardType']")));
            //creditCardSelect.selectByVisibleText("Master card");
            //2.28 Fill all the details
            WebElement cardholderNameInput = driver.findElement(By.xpath("//input[@id='CardholderName']"));
            cardholderNameInput.sendKeys("Jai Patel");
            //2.29 Click on “CONTINUE”
            continueButton = driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']//input[@class='button-1 payment-method-next-step-button']"));
            continueButton.click();
            //2.30 Verify “Payment Method” is “Credit Card”
            WebElement paymentMethodLabel = driver.findElement(By.xpath("//span[@class='payment-method-name']"));
            String expectedPaymentMethod = "Credit Card";
            Assert.assertEquals(paymentMethodLabel.getText(), expectedPaymentMethod);
            //2.31 Verify “Shipping Method” is “Next Day Air”
            WebElement shippingMethodLabel = driver.findElement(By.xpath("//li[@class='shipping-method']//span[@class='value-summary']"));
            String expectedShippingMethod = "Next Day Air";
            Assert.assertEquals(shippingMethodLabel.getText(), expectedShippingMethod);
           //2.32  Verify Total is “$2,950.00”
            WebElement totalAmountLabel = driver.findElement(By.xpath("//tr[@class='order-total']//span[@class='cart-total-right']"));
            String expectedTotalAmount = "$2,950.00";
            Assert.assertEquals(totalAmountLabel.getText(), expectedTotalAmount);
            //2.33 Click on “CONFIRM”
            WebElement confirmButton = driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']//input[@class='button-1 confirm-order-next-step-button']"));
            confirmButton.click();
            //2.34 Verify the Text “Thank You”
            WebElement thankYouMessage = driver.findElement(By.xpath("//h1[contains(text(),'Thank you')]"));
            String expectedThankYouMessage = "Thank you";
            Assert.assertEquals(thankYouMessage.getText(), expectedThankYouMessage);
            //2.35 Verify the message “Your order has been successfully processed!”
            WebElement successMessage1 = driver.findElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
            String expectedSuccessMessage1 = "Your order has been successfully processed!";
            Assert.assertEquals(successMessage.getText(), expectedSuccessMessage);
            //2.36 Click on “CONTINUE”
            continueButton = driver.findElement(By.xpath("//input[@class='button-1 order-completed-continue-button']"));
            continueButton.click();
            //2.37 Verify the text “Welcome to our store”
            WebElement welcomeMessage1 = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
            String expectedWelcomeMessage1 = "Welcome to our store";
            Assert.assertEquals(welcomeMessage.getText(), expectedWelcomeMessage);
        }
}



