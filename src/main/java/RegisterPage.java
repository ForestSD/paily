import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class RegisterPage {

    public WebDriver driver;
    public Faker faker = new Faker();
    private Map<String, String> map = new HashMap<String, String>();
    public static String email;
    public static String password;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerNewUser(){
        wait(10);
        inputValidParameter("#label_company_name", getFirstName());
        wait(10);
        inputValidParameter("#label_first_name", getLastName());
        driver.findElement(By.cssSelector("#label_last_name")).click();
    }

    public void inputValidParameter(String cssSelector, String fakerName){
        WebElement name = driver.findElement(By.cssSelector(cssSelector));
        name.click();
        name.sendKeys(fakerName);
    }

    public String getFirstName(){
        return faker.name().firstName();
    }

    public String getLastName(){
        return faker.name().lastName();
    }

    public void wait(int value){
        new WebDriverWait(driver, value);
    }

    public void read(){
        map = getHashMapFromTextFile();
        for(Map.Entry<String, String> entry : map.entrySet()){
            email = entry.getKey();
            password = entry.getValue();
        }
    }

    public static Map<String, String> getHashMapFromTextFile(){
        File file = Main.getFile();
        Map<String, String> mapFileContents = new HashMap<String, String>();
        try{
            BufferedReader br = new BufferedReader( new FileReader(file) );
            String line = null;
            while ( (line = br.readLine()) != null ){
                String[] parts = line.split(":");
                String name = parts[0].trim();
                String age =  parts[1].trim();
                if( !name.equals("") && !age.equals("") )
                    mapFileContents.put(name, age);
                if(br != null){
                    try {
                        br.close();
                    }catch(Exception e){};
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return mapFileContents;

    }

    public Map<String, String> getMap() {
        return map;
    }

}
