package vytrack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vytrack.utilities.Driver;

public class ContactsPage extends BasePage {

    @FindBy(css=".input-widget")
    public WebElement pageNumber;


    public WebElement getContactEmail(String email){
        String xpath = "//*[contains(text(), '"+email+"') and @data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }


}

