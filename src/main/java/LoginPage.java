import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;
    private Wait<WebDriver> wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5, 200);
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
        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(by)));
        label.click();
        label.sendKeys(variable);

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(account.getUsername());
    }

}
