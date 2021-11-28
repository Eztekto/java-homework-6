package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TicketsPage extends AbstractPage {


    private WebElement searchQuery = driver.findElement(By.id("search_query"));

    public void ticketSearch(String problem){
        this.searchQuery.sendKeys(problem);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"searchform\"]/div/div/button"));
        searchButton.click();
        List<WebElement> webElementList = driver.findElements(By.xpath("//*[@id=\"ticketTable\"]"));
        for (WebElement webElement : webElementList) {
            try {
                System.out.println("Тикет " + webElement.findElement(By.xpath("//*[@id=\"ticketTable\"]/tbody/tr[1]/td[2]")).getText());
            } catch (NoSuchElementException e) {
                System.out.println("Тикета не найден");
            }
        }


    }
}
