package vytrack.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import vytrack.pages.ContactInfoPage;
import vytrack.pages.ContactsPage;
import vytrack.pages.DashboardPage;
import vytrack.utilities.BrowserUtils;
import vytrack.utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class ContactsStepDef {

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        BrowserUtils.waitFor(2);
        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);

        Assert.assertEquals(menuOptions, actualOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);

    }

    @When("the user clicks the {string} from contacts")
    public void the_user_clicks_the_from_contacts(String email) {

        BrowserUtils.waitFor(3);
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.getContactEmail(email).click();

    }

    @Then("the information should be same with database")
    public void the_information_should_be_same_with_database() {
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullName = contactInfoPage.userName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        System.out.println("actualFullName = " + actualFullName);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);

        String query ="select concat(first_name,' ',last_name) as \"full_name\",e.email,phone\n" +
                "from orocrm_contact c join orocrm_contact_email e\n" +
                "on c.id = e.owner_id join orocrm_contact_phone p\n" +
                "on e.owner_id = p.owner_id\n" +
                "where e.email='mbrackstone9@example.com'";

        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        String expectedFullName = (String) rowMap.get("full_name");
        String expectedEmail = (String) rowMap.get("email");
        String expectedPhone = (String) rowMap.get("phone");

        System.out.println("expectedFullName = " + expectedFullName);
        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhone = " + expectedPhone);

        Assert.assertEquals(expectedFullName, actualFullName);
        Assert.assertEquals(expectedEmail, actualEmail);
        Assert.assertEquals(expectedPhone, actualPhone);
    }

    @Then("the information for {string} should be same with database")
    public void the_information_for_should_be_same_with_database(String email) {
        //get information from UI
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullName = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        System.out.println("actualFullName = " + actualFullName);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);

        //get information from database

        //we are getting only one row of result
        //query for retrieving firstname,lastname,email,phone
        String query ="select concat(first_name,' ',last_name) as \"full_name\",e.email,phone\n" +
                "from orocrm_contact c join orocrm_contact_email e\n" +
                "on c.id = e.owner_id join orocrm_contact_phone p\n" +
                "on e.owner_id = p.owner_id\n" +
                "where e.email='"+email+"'";
        //get info and save in the map
        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        String expectedFullName = (String) rowMap.get("full_name");
        String expectedPhone = (String) rowMap.get("phone");
        String expectedEmail = (String) rowMap.get("email");

        System.out.println("expectedFullName = " + expectedFullName);
        System.out.println("expectedPhone = " + expectedPhone);
        System.out.println("expectedEmail = " + expectedEmail);


        //assertion, Compare UI against to DB
        Assert.assertEquals(expectedFullName,actualFullName);
        Assert.assertEquals(expectedEmail,actualEmail);
        Assert.assertEquals(expectedPhone,actualPhone);
    }

}
