package vytrack.step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import vytrack.pages.DashboardPage;
import vytrack.utilities.BrowserUtils;

import java.util.List;

public class ContactsStepDef {

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        BrowserUtils.waitFor(2);
        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);

        Assert.assertEquals(menuOptions, actualOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);

    }
}
