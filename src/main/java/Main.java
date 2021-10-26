import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Main {

    public static String setProperty = System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\IdeaProjects\\paily\\drivers\\chromedriver.exe");
    public static WebDriver driver = new ChromeDriver();
    private static File file;

    public static void main(String[] args) {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CreateNewInvoice newInvoice = new CreateNewInvoice(driver);
        driver.get("https://paily.io/en");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("a.login"));
        //driver.findElement(By.cssSelector("a.register")).click();
        //registerPage.registerNewUser();
        //driver.get("https://tempr.email/");
        //createNewFile();
        createNewFile();
        registerPage.read();
        loginPage.loginForm(driver);
        wait(20);
        newInvoice.createNewInvoice();
        //registerPage.registerNewUser();

    }

    public static void createNewFile() {
        String fileSeparator = System.getProperty("file.separator");

        file = new File("emailsAndPassword.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("emailsAndPassword.txt" + " Файл создан");
            } else {
                System.out.println("Файл " + "emailsAndPassword.txt" + " уже существует");
            }
                //создаем файл только с указанием имени файла
                file = new File("emailsAndPassword.txt");
                if (file.createNewFile()) {
                    System.out.println("emailsAndPassword.txt файл создан в корневой директории проекта");
                } else {
                    System.out.println("emailsAndPassword.txt файл уже существует в корневой директории проекта");
                    return;
                }
                //создаем файл с указанием относительного пути к файлу
                String relativePath = "tmp" + fileSeparator + "emailsAndPassword.txt";
                file = new File(relativePath);
                if (file.createNewFile()) {
                    System.out.println(relativePath + " файл создан в корневой директории проекта");
                } else System.out.println("Файл " + relativePath + " уже существует в директории проекта");
            } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    public static File getFile() {
        return file;
    }

    public static void wait(int value){
        new WebDriverWait(driver, value);
    }
}
