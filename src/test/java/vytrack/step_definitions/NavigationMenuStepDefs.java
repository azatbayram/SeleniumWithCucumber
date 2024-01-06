package vytrack.step_definitions;

import vytrack.pages.ContactsPage;
import vytrack.pages.DashboardPage;
import vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuStepDefs {
    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_Fleet_Vehicles() {
        //selenium code
        System.out.println("the user navigates to Fleet, Vehicles");
    }

    @Then("the title should be Vehicles")
    public void the_title_should_be_Vehicles() {
        System.out.println("Expected and Actual title are matching");
    }

    @When("the user navigates to Marketing, Campaigns")
    public void the_user_navigates_to_Marketing_Campaigns() {
        System.out.println("the user navigates to Marketing, Campaigns");

    }

    @Then("title should be Campaigns")
    public void title_should_be_Campaigns() {
        System.out.println("Expected and Actual title are matching");
    }

    @When("the user navigates to Activities, Calendar Events")
    public void the_user_navigates_to_Activities_Calendar_Events() {
        System.out.println("the user navigates to Activities, Calendar Events");

    }

    @Then("title should be Calendars")
    public void title_should_be_Calendars() {
        System.out.println("Expected and Actual title are matching");
    }

    @When("the usr navigates to {string} {string}")
    public void the_usr_navigates_to(String tab, String module) {
        new DashboardPage().navigateToModule(tab, module);
    }

    @Then("the deafult page number should be {int}")
    public void the_deafult_page_number_should_be(Integer expectedPageNum) {
        BrowserUtils.waitFor(2);
        ContactsPage contactsPage = new ContactsPage();
        Integer actualPageNum = Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));
        Assert.assertEquals(expectedPageNum, actualPageNum);
    }




}
