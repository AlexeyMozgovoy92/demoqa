package pages;

import com.codeborne.selenide.Selenide;
import pages.components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPage {

    Calendar calendar = new Calendar();

    public RegistrationFormPage openPage() {
        Selenide.open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }
    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }
    public RegistrationFormPage setGender() {
        $("#genterWrapper").$(byText("Male")).click();
        return this;
    }
    public RegistrationFormPage setPhone(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }
    public RegistrationFormPage setSubject(String value) {
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }
    public RegistrationFormPage setHobbies() {
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbies-checkbox-2").parent().click();

        $("#hobbies-checkbox-1").parent().click();
        // $("#hobbiesWrapper").$(byText("Sports")).click();

        return this;
    }


    public RegistrationFormPage uploadPicture() {
        $("#uploadPicture").uploadFromClasspath("images/aleksei.jpg");

        return this;
    }
    public RegistrationFormPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationFormPage setStateAndCity() {
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        return this;
    }
}
