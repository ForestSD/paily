import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public Manager manager;

    public void loginForm(WebDriver driver){
        driver.findElement(By.cssSelector("a.login"));
        driver.findElement(By.xpath("//a[contains(@class, 'login')]")).click();
        clickAndSaveVariableInInput("#label_email", RegisterPage.email);
        clickAndSaveVariableInInput("#label_password", RegisterPage.password);
        driver.findElement(By.cssSelector("button > span")).click();
    }


    public void clickAndSaveVariableInInput(String by, String variable){
        WebElement label_email = driver.findElement(By.cssSelector(by));
        label_email.click();
        label_email.sendKeys(variable);
    }


}
