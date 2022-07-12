package sonic.vap.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    private static final Logger logger = LogManager.getLogger(BaseClass.class);
    public static WebDriver driver = null;
    public static int PAGE_LOAD_TIMEOUT = 15;

    private static void driverInitialization(Object capabilities) {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver((ChromeOptions) capabilities);
            logger.info("Browser is Opening");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("NOT able to open the Browser");
        }
    }

    private static ChromeOptions browsePreSetUp() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("window-size=1920,681");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        return options;
    }

    private static void driverSetUp(String url) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.get(url);
        logger.info("URL Entered: " + url);
    }

    public static void driverInitialization() {
        driverInitialization(browsePreSetUp());
        driverSetUp("https://sonicvapeusa.com/");
    }
}
