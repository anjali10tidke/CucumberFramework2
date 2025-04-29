package com.vtiger.stepdefinations;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.leadpage;
import com.vtiger.pages.loginpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class basesteps {

    public static WebDriver driver;
    public static loginpage lp;
    public static leadpage ldp;
    public static Properties prop;
    public static Map<String,Map<String,String>> dt;

    public void readproperties() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Configuration/setting.properties");
        prop.load(fis);
    }

    public void launchApp() throws Exception, FilloException {

        if (dt==null)
        {
            readexcelData();
        }

        //System.exit(0);
        if (prop==null) {
            readproperties();
        }
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("headless"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);

        }
        else{
            driver = new ChromeDriver();
        }

        driver.get(prop.getProperty("appurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("globalwait"))));
        lp = new loginpage(driver);
        ldp= new leadpage(driver);
    }

    public void readexcelData() throws FilloException {
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection(System.getProperty("user.dir")+"/src/test/resources/TestData/data.xlsx");
        String strQuery="Select * from Sheet1";
        Recordset recordset=connection.executeQuery(strQuery);

        List<String> lst = recordset.getFieldNames();


         dt = new HashMap<>();

        while(recordset.next()){
            //System.out.println(recordset.getField("Details"));
            Map<String,String> rdata = new HashMap<>();
            for (int i=1;i<lst.size();i++)
            {
                rdata.put(lst.get(i),recordset.getField(lst.get(i)));
            }
            dt.put(recordset.getField("ScenarioName"),rdata);

        }



        recordset.close();
        connection.close();

        System.out.println(dt);
    }

}
