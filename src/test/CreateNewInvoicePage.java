import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("force-device-scale-factor=0.75");
        chromeOptions.addArguments("high-dpi-support=0.75");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://paily.io/en");
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
        newInvoice = new CreateNewInvoice(driver);
        loginPage = new LoginPage(driver);
    }

    @After
    @Test
    public void loginInPage(){
        registerPage.read();
        loginPage.loginForm(driver, "testUser2@tempr.email", "3OJT6j8c");
        driver.quit();
    }

    @Test
    public void nullValueInputLoginPage(){
        registerPage.read();
        loginPage.loginForm(driver, "", "");
        Assert.fail("Значение null");
        driver.quit();
    }

    @Test
    public void notValidEmailLoginPage(){
        registerPage.read();
        loginPage.loginForm(driver, "testUser2", "3OJT6j8c");
        Assert.fail("Не верный email");
        driver.quit();
    }


    /*@Test
    public void createInvoice(){
        registerPage.read();
        loginPage.loginForm(driver, "testUser2@tempr.email", "3OJT6j8c");
        Faker faker = new Faker();
        Name name = faker.name();
        newInvoice.createNewInvoice(name.username(), name.fullName(),faker.address().streetName(),
                faker.internet().emailAddress(),name.fullName());
        driver.quit();
    }*/

}
