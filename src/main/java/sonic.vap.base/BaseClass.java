package sonic.vap.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BaseClass {
    private static final Logger logger = LogManager.getLogger(BaseClass.class);
    protected static final String CHROME_BROWSER = "chrome";
    protected static final String EDGE_BROWSER = "edge";
    public static WebDriver driver = null;
    protected static String SET_BROWSER = null;

    protected static void driverInitialization(String browser, Object capabilities) {
        SET_BROWSER = browser;
        try {
            switch (browser.toLowerCase()) {
                case EDGE_BROWSER:
                    driver = new EdgeDriver((EdgeOptions) capabilities);
                    break;

                case CHROME_BROWSER:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver((ChromeOptions) capabilities);
                    break;
            }
            logger.info("Browser is Opening: " + browser.toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("NOT able to open the Browser: " + browser.toUpperCase());
        }
    }
}
