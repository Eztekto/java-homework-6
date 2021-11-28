package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "username")
    private WebElement username;

    public WebElement getPassword() {
        return password;
    }

    public WebElement getUsername() {
        return username;
    }


    public void login(String user, String password) {
        getUsername().sendKeys(user);
        getPassword().sendKeys(password);


    }
}
