package test;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static test.TestData.*;

public class FormTest  extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @Test
    void successfulFillFormTest() {

        registrationFormPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setGender()
                .setPhone(PHONE);

        registrationFormPage.setDateOfBirth("30", "June", "1992");

        registrationFormPage.uploadPicture();

        registrationFormPage.setSubject("Physics")
                        .setHobbies()
                        .setCurrentAddress("Baker Street, 221B")
                        .setStateAndCity();

        $("#submit").click();

        $(".modal-body").shouldHave(text(FIRST_NAME), text(LAST_NAME),
                text(EMAIL), text("Male"), text(PHONE),
                text(30 + " " + "June" + "," + 1992),
                text("Physics"), text("Music"), text("Sports"),text("Reading"),
                text("aleksei.jpg"), text("Baker Street, 221B"),
                text("Haryana" + " " + "Karnal"));

    }
}
