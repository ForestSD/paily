import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class CreateNewInvoicePage {


    public WebDriver driver;
    public RegisterPage registerPage;
    public CreateNewInvoice newInvoice;
    public LoginPage loginPage;

    @BeforeClass
    public static void beforeAll(){
        String string = System.setProperty("webdriver.chrome.driver", "C:\\Users\\PandaTeam\\IdeaProjects\\paily\\drivers\\chromedriver.exe");
    }

    @Before
    public void before(){
        Manager manager = new Manager(driver);
        driver = new ChromeDriver();
        driver.get("https://paily.io/en");
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
        newInvoice = new CreateNewInvoice(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void createInvoice(){
        registerPage.read();
        loginPage.loginForm(driver);
        Faker faker = new Faker();
        Name name = faker.name();
        newInvoice.createNewInvoice(name.username(), name.fullName(),faker.address().streetName(),
                faker.internet().emailAddress(),name.fullName());
    }

}
