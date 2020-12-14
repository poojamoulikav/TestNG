package com.open.hotel.tests;

import com.open.hotel.loadConfig.Config;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BaseClass {
    String Browser = null;
    String Environment = null;
    //WebDriver driver;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public WebDriver getDriver() {
        return driver.get();
    }
    public void setWebDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
        Config.createFolder(Config.properties.getProperty("resultFolder"));
        Config.createFolder(Config.properties.getProperty("resultFolderName"));
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
        String name = "pooja";
        name = "Anu";
        System.out.println(name);
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
        getDriver().close();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
        WebDriver driver;
        String Browser = Config.properties.getProperty("Browser");
        String ExecutionMode = Config.properties.getProperty("ExecutionMode");
        String RemoteType = Config.properties.getProperty("RemoteType");
        String RemoteURL = Config.properties.getProperty("RemoteURL");
        String driverPath = System.getProperty("user.dir");
        if(ExecutionMode.contains("Local")) {
            if (Browser.toUpperCase().contains("CH")) {
                System.setProperty("webdriver.chrome.driver", driverPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("no-sandbox");
                options.addArguments("start-maximized");
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
                driver = new ChromeDriver(options);
                setWebDriver(driver);
            }
        } else if (ExecutionMode.contains("Grid")) {
            // RemoteWebDriver driver = null;
            DesiredCapabilities cap = null;
            if (Browser.toUpperCase().contains("CH")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("no-sandbox");
                options.addArguments("start-maximized");
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                options.setExperimentalOption("useAutomationExtension", false);
                options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
                cap = DesiredCapabilities.chrome();
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                cap.setBrowserName("chrome");
                if (RemoteType.contains("VM")) {
                    cap.setPlatform(Platform.WINDOWS);
                } else if (RemoteType.contains("AWS")) {
                    cap.setPlatform(Platform.LINUX);
                }
            }
            try {
                driver = new RemoteWebDriver(new URL(RemoteURL), cap);
                setWebDriver(driver);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");

    }
}
