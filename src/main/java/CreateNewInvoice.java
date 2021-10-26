import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CreateNewInvoice {

    private WebDriver driver;

    public CreateNewInvoice(WebDriver driver) {
        this.driver = driver;
    }

    public void createNewInvoice(String username, String fullName, String street, String email, String servicesName){
        findByCssClickInButton("div.view-more > a");
        findByCssClickInButton("#butId");
        inputValidParameter("#newprojectname", username);
        findByCssClickInButton("button > span");
        inputValidParameterByName("fio", fullName);
        inputValidParameterByName("address", street);
        inputValidParameterByName("email", email);
        driver.findElement(By.xpath("//*[@class=\"vs__dropdown-toggle\"]")).click();
        List<WebElement> elements = driver.findElements(By.cssSelector("#vs1__listbox"));
        for (WebElement element : elements) {
            if (element.getText().contains("Aland Islands")){
                element.click();
                break;
            }
        }
        findByCssClickInButton("button > span");
        inputValidParameterByName("names_services", servicesName);
        inputValidParameterByName("time", 1);
        inputValidParameterByName("price", 100);
        findByCssClickInButton("a > span");
        WebElement element = driver.findElement(By.cssSelector("div > div.newProject > button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.newProject > button"))).click();
    }

    public  void inputValidParameter(String cssSelector, String fakerName){
        WebElement name = driver.findElement(By.cssSelector(cssSelector));
        name.click();
        name.sendKeys(fakerName);
    }

    public  void inputValidParameterByName(String nameSelector, String fakerName){
        WebElement name = driver.findElement(By.name(nameSelector));
        name.click();
        name.sendKeys(fakerName);
    }

    public  void inputValidParameterByName(String nameSelector, int number){
        WebElement name = driver.findElement(By.name(nameSelector));
        name.click();
        name.sendKeys(String.valueOf(number));
    }

    public  void findByCssClickInButton(String selector){
        driver.findElement(By.cssSelector(selector)).click();
    }

}
