import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateNewInvoice {

    public WebDriver driver;
    public Faker faker = new Faker();

    public CreateNewInvoice(WebDriver driver) {
        this.driver = driver;
    }

    public void createNewInvoice(){
        findByCssClickInButton("div.view-more > a");
        findByCssClickInButton("#butId");
        inputValidParameter("#newprojectname", faker.name().username());
        findByCssClickInButton("button > span");
        inputValidParameterByName("fio", faker.name().fullName());
        inputValidParameterByName("address", faker.address().streetName());
        Select country = new Select(driver.findElement(By.xpath("//*[@id=\"vs2__combobox\"]")));
        country.deselectByVisibleText("Austria");
    }

    public void inputValidParameter(String cssSelector, String fakerName){
        WebElement name = driver.findElement(By.cssSelector(cssSelector));
        name.click();
        name.sendKeys(fakerName);
    }

    public void inputValidParameterByName(String nameSelector, String fakerName){
        WebElement name = driver.findElement(By.name(nameSelector));
        name.click();
        name.sendKeys(fakerName);
    }

    public void inputValidParameterByXpath(String xpathSelector, String fakerName){
        WebElement name = driver.findElement(By.xpath(xpathSelector));
        name.click();
        name.sendKeys(fakerName);
    }

    public void findByCssClickInButton(String selector){
        driver.findElement(By.cssSelector(selector)).click();
    }
}
