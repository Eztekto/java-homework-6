package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketsPage extends AbstractPage {


    private WebElement searchQuery = driver.findElement(By.id("search_query"));

    public void ticketSearch(String problem) {
        this.searchQuery.sendKeys(problem);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"searchform\"]/div/div/button"));
        searchButton.click();
        WebElement titleElement = driver.findElement(By.xpath("//tr[@class]//a"));
        Assert.assertTrue("Нет тикета",titleElement.getText().contains(problem));

    }


}

