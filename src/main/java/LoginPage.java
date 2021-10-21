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

    public void loginForm(WebDriver driver){
        driver.findElement(By.xpath("//a[contains(@class, 'login')]")).click();
        wait(10);
        clickAndSaveVariableInInput("#label_email", RegisterPage.email);
        wait(20);
        clickAndSaveVariableInInput("#label_password", RegisterPage.password);
        wait(5);
        driver.findElement(By.cssSelector("button > span")).click();
    }

    public void wait(int value){
        new WebDriverWait(driver, value);
    }

    public void clickAndSaveVariableInInput(String by, String variable){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement label_email = driver.findElement(By.cssSelector(by));
        label_email.click();
        label_email.sendKeys(variable);
    }

}
