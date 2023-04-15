import io.opentelemetry.api.internal.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeTest
    public static void setup() {
        // ChromeDriver location set up in Utils class
       // System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.get(Util.BASE_URL);
        driver.manage().window().maximize();
    }

    @Test(testName = "Submit a WebForm")
    public static void submitForm(){

        WebForm webForm = new WebForm(driver);
        //Enter First Name
        webForm.enterFirstName(Util.FIRST_NAME);
        // Enter Last Name
        webForm.enterLastName(Util.LAST_NAME);
        // Click Submit Button
        webForm.pressSubmitButton();
    }
    @Test(testName = "Validate success Message")
    public static void validateSuccessMessage(){

        WebForm webForm = new WebForm(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webForm.verifyAlertSuccess();
    }


    @AfterTest
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}