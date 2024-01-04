package vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends vytrack.pages.BasePage {

    @FindBy(className = "user-name")
    public WebElement contactFullName;

    @FindBy(css="a.phone")
    public WebElement phone;

    @FindBy(css="a.email")
    public WebElement email;

}
