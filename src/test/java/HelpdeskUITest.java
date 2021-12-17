import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AbstractPage;
import pages.LoginPage;
import pages.MainPage;
import pages.TicketsPage;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.System.getProperty;

public class HelpdeskUITest {

    private WebDriver driver;

    @Before
    public void setup() throws IOException {
        // Читаем конфигурационный файл в System.properties

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("ticket.properties"));

        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest()  {
        driver.get(getProperty("site.url"));
        MainPage submitPage = new MainPage();
        submitPage.submitTicket(System.getProperty("queue"), System.getProperty("problem"),
                System.getProperty("issue"), System.getProperty("email"), System.getProperty("priority"));

        WebElement authorization = driver.findElement(By.id("userDropdown"));
        authorization.click();
        LoginPage loginPage = new LoginPage();
        loginPage.login(System.getProperty("user"), System.getProperty("password"));
        TicketsPage searchPage = new TicketsPage();
        searchPage.ticketSearch(System.getProperty("problem"));
        driver.quit();


    }
}
