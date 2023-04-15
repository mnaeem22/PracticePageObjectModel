// Page URL: https://formy-project.herokuapp.com/form
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebForm extends PageObject{


    @FindBy(id = "first-name")
    private WebElement first_name;


    @FindBy(id = "last-name")
    private WebElement last_name;

    @FindBy(xpath = "//a[contains(text(),'Submit')]")
    private WebElement submit_button;

    @FindBy(xpath = "//div[contains(text(),'The form was successfully submitted!')]")
    private WebElement alertSuccess;


    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName){
        this.first_name.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        this.last_name.sendKeys(lastName);
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public void verifyAlertSuccess(){
        this.alertSuccess.isDisplayed();
    }
}