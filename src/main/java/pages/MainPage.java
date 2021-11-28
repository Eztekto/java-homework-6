package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends AbstractPage {
    private WebElement problem = driver.findElement(By.id("id_title"));
    private WebElement issue = driver.findElement(By.id("id_body"));
    private WebElement email = driver.findElement(By.id("id_submitter_email"));


    public void submitTicket(String queue, String problem, String issue, String email, String priority) {

        Select queueSelect = new Select(driver.findElement(By.xpath("//*[@id=\"id_queue\"]")));
        queueSelect.selectByVisibleText(queue);
        Select prioritySelect = new Select(driver.findElement(By.xpath("//*[@id=\"id_priority\"]")));
        prioritySelect.selectByVisibleText(priority);
        this.problem.sendKeys(problem);
        this.issue.sendKeys(issue);
        this.email.sendKeys(email);
        WebElement ticketButton = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/div/div/form/button"));
        ticketButton.click();


    }

}
