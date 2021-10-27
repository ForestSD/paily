import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateNewInvoice {

    private WebDriver driver;
    private Wait<WebDriver> wait;

    public CreateNewInvoice(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5, 200);
    }

    public void createNewInvoice(String username, String fullName, String street, String email, String servicesName){
        findByCssClickInButton("div.view-more > a");
        findByCssClickInButton("#butId");
        inputValidParameter("#newprojectname", username);
        findByCssClickInButton("div.newProject > button");
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
        /*WebElement element = driver.findElement(By.cssSelector("div > div.newProject > button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.newProject > button"))).click();*/
        findByCssClickInButton("div > div.newProject > button");
        WebElement finalButton = driver.findElement(By.cssSelector("div > div:nth-child(1) > button"));
        wait.until(ExpectedConditions.visibilityOf(finalButton));
        findByCssClickInButton("div > div:nth-child(1) > button");
    }

    public  void inputValidParameter(String cssSelector, String fakerName){
        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        label.click();
        label.sendKeys(fakerName);
    }

    public  void inputValidParameterByName(String nameSelector, String fakerName){
        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(By.name(nameSelector)));
        label.click();
        label.sendKeys(fakerName);
    }

    public  void inputValidParameterByName(String nameSelector, int number){
        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(By.name(nameSelector)));
        label.click();
        label.sendKeys(String.valueOf(number));
    }

    public  void findByCssClickInButton(String selector){
        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        label.click();
    }

}
