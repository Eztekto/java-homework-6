package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractPage {
    private WebElement user = driver.findElement(By.id("username"));
    private WebElement password = driver.findElement(By.id("password"));







    public void login(String user, String password) {
        this.user.sendKeys(user);
        this.password.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/input[1]"));
        loginButton.click();



    }
}
