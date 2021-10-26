import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Manager {

    public WebDriver driver;

    public Manager(WebDriver driver) {
        this.driver = driver;
    }

    public  Map<String, String> map = new HashMap<String, String>();
    public  String email;
    public  String password;

    public void read(){
        map = getHashMapFromTextFile();
        for(Map.Entry<String, String> entry : map.entrySet()){
            email = entry.getKey();
            password = entry.getValue();
        }
    }

    public Map<String, String> getHashMapFromTextFile(){
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
