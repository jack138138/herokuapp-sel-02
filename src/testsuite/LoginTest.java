package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String MyUrl = "http://the-internet.herokuapp.com/login";

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //open url
        openBrowser(MyUrl);
        //input valid credential
        Mydriver.findElement(By.name("username")).sendKeys("tomsmith");

        //input valid password
        Mydriver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //click on login button
        Mydriver.findElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']")).click();

        //verify Message on board
        String expectedMessage = "Secure Area";
        String actualMessage = Mydriver.findElement(By.xpath("/html/body/div[2]/div/div/h2")).getText();
        Assert.assertEquals("Error in page",expectedMessage,actualMessage);
    }
@Test
    public void verifyTheUsernameErrorMessage(){
        //open browser
        openBrowser(MyUrl);
        //input invalid username
        Mydriver.findElement(By.name("username")).sendKeys("tomsmith1");
        //input valid password
        Mydriver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //click on login button
        Mydriver.findElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']")).click();

        //verify message on display
        String expectedErrorText = "Your username is invalid!";
        String actualErrorText = Mydriver.findElement(By.xpath("//a[@href = '#' or class = 'close']")).getText();
        Assert.assertEquals("Error Message",expectedErrorText,actualErrorText);

    }

    @Test
     public void verifyThePasswordErrorMessage(){
        //open url
         openBrowser(MyUrl);
         //input valid usename
         Mydriver.findElement(By.name("username")).sendKeys("tomsmith");
         // input invalid password
         Mydriver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
         //click on login button
         Mydriver.findElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']")).click();

         // verify Error text which is displayed on board
        String expectedErrorText = "Your password is invalid!";
        String actualErrorText = Mydriver.findElement(By.xpath("//a[@href = '#']")).getText();
        Assert.assertEquals("Error Message",expectedErrorText,actualErrorText);

     }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
