package test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FormTestWithFaker extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @Test
    void successfulFillFormTest() {
        Faker faker = new Faker();
        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().subscriberNumber(10);
        String address = faker.address().fullAddress();

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender()
                .setPhone(phone);

        registrationFormPage.setDateOfBirth("30", "June", "1992");

        registrationFormPage.uploadPicture();

        registrationFormPage.setSubject("Physics")
                        .setHobbies()
                        .setCurrentAddress(address)
                        .setStateAndCity();

        $("#submit").click();

        $(".modal-body").shouldHave(text(firstName), text(lastName),
                text(email), text("Male"), text(phone),
                text(30 + " " + "June" + "," + 1992),
                text("Physics"), text("Music"), text("Sports"),text("Reading"),
                text("aleksei.jpg"), text(address),
                text("Haryana" + " " + "Karnal"));

    }
}
