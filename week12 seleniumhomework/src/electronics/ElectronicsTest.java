package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/*Write the following test
1. Test name text verified()
1.1 Mouse Hover on “Electronics” Tab
1.2 Mouse Hover on “Cell phones” and click
1.3 Verify the text “Cell phones”*/
public class ElectronicsTest extends Utility {
    String baseurl = "https://demo.nopcommerce.com";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void textVerified() {
        // 1.1 Mouse Hover on "Electronics" Tab
        WebElement electronicsTab = driver.findElement(By.xpath("//h2[a='Electronics']"));
        Actions action = new Actions(driver);
        action.moveToElement(electronicsTab).perform();

        // 1.2 Mouse Hover on "Cell phones" and click
        WebElement cellPhonesLink = driver.findElement(By.xpath("//a[text()='Cell phones']"));
        action.moveToElement(cellPhonesLink).click().perform();

        // 1.3 Verify the text "Cell phones"
        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        String expectedText = "Cell phones";
        Assert.assertEquals(pageTitle.getText(), expectedText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() {
        // 2.1 Mouse Hover on "Electronics" Tab
        WebElement electronicsTab = driver.findElement(By.xpath("//a[text()='Electronics']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronicsTab).perform();

        // 2.2 Mouse Hover on "Cell phones" and click
        WebElement cellPhonesLink = driver.findElement(By.xpath("//a[text()='Cell phones']"));
        actions.moveToElement(cellPhonesLink).click().perform();

        // 2.3 Verify the text "Cell phones"
        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        String expectedText = "Cell phones";
        Assert.assertEquals(pageTitle.getText(), expectedText);

        // 2.4 Click on List View Tab
        WebElement listViewTab = driver.findElement(By.xpath("//a[text()='List']"));
        listViewTab.click();

        // 2.5 Click on product name "Nokia Lumia 1020" link
        WebElement productLink = driver.findElement(By.xpath("//a[text()='Nokia Lumia 1020']"));
        productLink.click();

        // 2.6 Verify the text "Nokia Lumia 1020"
        WebElement productTitle = driver.findElement(By.xpath("//h1[contains(@class, 'product-title')]"));
        expectedText = "Nokia Lumia 1020";
        Assert.assertEquals(productTitle.getText(), expectedText);

        // 2.7 Verify the price "$349.00"
        WebElement productPrice = driver.findElement(By.xpath("//span[@itemprop='price']"));
        expectedText = "$349.00";
        Assert.assertEquals(productPrice.getText(), expectedText);

        // 2.8 Change quantity to 2
        WebElement quantityInput = driver.findElement(By.xpath("//input[@id='product_enteredQuantity_1']"));
        quantityInput.clear();
        quantityInput.sendKeys("2");

        // 2.9 Click on "ADD TO CART" tab
        WebElement addToCartButton = driver.findElement(By.xpath("//input[@value='Add to cart']"));
        addToCartButton.click();

        // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='bar-notification success']"));
        expectedText = "The product has been added to your shopping cart";
        Assert.assertTrue(successMessage.getText().contains(expectedText));
        // After that close the bar clicking on the cross button.
        WebElement closeButton = driver.findElement(By.xpath("//span[@class='close']"));
        closeButton.click();
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        WebElement shoppingCartLink = driver.findElement(By.xpath("//a[text()='Shopping cart']"));
        actions.moveToElement(shoppingCartLink).click().perform();
        //2.12 Verify the message "Shopping cart"
        WebElement cartPageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        expectedText = "Shopping cart";
        Assert.assertEquals(cartPageTitle.getText(), expectedText);
        //2.13 Verify the quantity is 2
        WebElement quantityValue = driver.findElement(By.xpath("//input[contains(@class, 'qty-input')]"));
        Assert.assertEquals(quantityValue.getAttribute("value"), "2");
        //2.14 Verify the Total $698.00
        WebElement totalPrice = driver.findElement(By.xpath("//span[@class='product-price']"));
        expectedText = "$698.00";
        Assert.assertEquals(totalPrice.getText(), expectedText);
        //2.15 click on checkbox “I agree with the terms of service
        WebElement agreeCheckbox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        agreeCheckbox.click();
        // 2.16 Click on checkout
        WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkoutButton.click();
        //“2.17 Verify the Text “Welcome, Please Sign In!”
        WebElement signInText = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        expectedText = "Welcome, Please Sign In!";
        Assert.assertEquals(signInText.getText(), expectedText);
        //2.18 Click on “REGISTER” tab
        WebElement registerTab = driver.findElement(By.xpath("//a[text()='Register']"));
        registerTab.click();
        //2.19 Verify the text “Register”
        WebElement registerTitle = driver.findElement(By.xpath("//h1[text()='Register']"));
        expectedText = "Register";
        Assert.assertEquals(registerTitle.getText(), expectedText);
        //2.20 Fill the mandatory fields
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='FirstName']"));
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='LastName']"));
        //fill name and surname
        firstNameField.sendKeys("Jai");
        lastNameField.sendKeys("patel");
        //2.21 Click on “REGISTER” Button
        WebElement registerButton = driver.findElement(By.xpath("//button[@id='register-button']"));
        registerButton.click();
        //2.22 Verify the message “Your registration completed”
        WebElement registrationCompletedText = driver.findElement(By.xpath("////div[@class='result']"));
        expectedText = "Your registration completed";
        Assert.assertEquals(registrationCompletedText.getText(), expectedText);
        //2.23 Click on “CONTINUE” tab
        WebElement continueTab = driver.findElement(By.xpath("//div/a[@class='button-1 register-continue-button']"));
        continueTab.click();
        //2.24 Verify the text “Shopping cart”
        WebElement shoppingCartText = driver.findElement(By.xpath("//li/a/span[@class='cart-label']"));
        expectedText = "Shopping cart";
        Assert.assertEquals(shoppingCartText.getText(), expectedText);
        //2.25 click on checkbox “I agree with the terms of service”
        agreeCheckbox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        agreeCheckbox.click();
        //2.26 Click on “CHECKOUT”
        WebElement checkoutButton1 = driver.findElement(By.xpath("//div/button[@class='button-1 checkout-button']"));
        checkoutButton1.click();
        //2.27 Fill the Mandatory fields
        WebElement firstName = driver.findElement(By.xpath("//div/label[@for='BillingNewAddress_FirstName']"));
        WebElement lastName = driver.findElement(By.xpath("//div/label[@for='BillingNewAddress_LastName']"));
        WebElement emailField = driver.findElement(By.xpath("//div/label[@for='BillingNewAddress_Email']"));
        //2.28 Click on “CONTINUE”
        WebElement continueButton1 = driver.findElement(By.xpath("//div/button[@class='button-1 new-address-next-step-button']"));
        continueButton1.click();
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        WebElement shippingMethod = driver.findElement(By.xpath("//div/label[@for='shippingoption_2']"));
        shippingMethod.click();
        //2.30 Click on “CONTINUE”
        WebElement continueButton3 = driver.findElement(By.xpath("//div/button[@class='button-1 shipping-method-next-step-button'"));
        continueButton3.click();
        //2.31 Select Radio Button “Credit Card”
        WebElement paymentMethod = driver.findElement(By.xpath("//div[@class='payment-description']"));
        paymentMethod.click();
        //2.32 Select “Visa” From Select credit card dropdown
        WebElement creditCardDropdown = driver.findElement(By.xpath("//select[@id='CreditCardType']"));
        Select creditCardSelect = new Select(creditCardDropdown);
        creditCardSelect.selectByVisibleText("Visa");
        //2.33 Fill all the details
        WebElement cardholderNameField = driver.findElement(By.xpath("//td/label[@for='CardholderName']"));
        WebElement cardNumberField = driver.findElement(By.xpath("//td/label[@for='CardNumber']"));
        //2.33 Fill all the details
        cardholderNameField.sendKeys("Jai Patel");
        cardNumberField.sendKeys("1234567890");
        //2.34 Click on “CONTINUE”CHECKOUT”
        WebElement continueButton4 = driver.findElement(By.xpath("//div/button[@class='button-1 payment-info-next-step-button']"));
        continueButton4.click();
        //2.35 Verify “Payment Method” is “Credit Card”
        WebElement paymentMethodText = driver.findElement(By.xpath("//div/label[@for='paymentmethod_1']"));
        expectedText = "Credit Card";
        Assert.assertEquals(paymentMethodText.getText(), expectedText);
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        WebElement shippingMethodText = driver.findElement(By.xpath("//div[@class='method-name']"));
        expectedText = "2nd Day Air";
        Assert.assertEquals(shippingMethodText.getText(), expectedText);
        //2.37 Verify Total is “$698.00”
        WebElement totalText = driver.findElement(By.xpath("//td/span[@class='value-summary']"));
        expectedText = "$698.00";
        Assert.assertEquals(totalText.getText(), expectedText);
        //2.38 Click on “CONFIRM”
        WebElement confirmButton = driver.findElement(By.xpath("//div/button[@class='button-1 confirm-order-next-step-button']"));
        confirmButton.click();
        //2.39 Verify the Text “Thank You”
        WebElement thankYouText = driver.findElement(By.xpath("//div[@class='page-title']"));
        expectedText = "Thank you";
        Assert.assertEquals(thankYouText.getText(), expectedText);
        //2.40 Verify the message “Your order has been successfully processed!”
        WebElement successMessage1 = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        expectedText = "Your order has been successfully processed!";
        Assert.assertEquals(successMessage.getText(), expectedText);
        //2.41 Click on “CONTINUE”
        WebElement continueButton5 = driver.findElement(By.xpath(" //div/button[@class='button-1 order-completed-continue-button']       "));
        continueButton5.click();
        //2.42 Verify the text “Welcome to our store”
        WebElement welcomeText = driver.findElement(By.xpath("//div/h2[text()='Welcome to our store']"));
        expectedText = "Welcome to our store";
        Assert.assertEquals(welcomeText.getText(), expectedText);
        //2.43 Click on “Logout” link
        WebElement logoutLink = driver.findElement(By.xpath("//li/a[@class='ico-account']"));
        logoutLink.click();
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedurl = "https://demo.nopcommerce.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedurl);
    }
}





















































