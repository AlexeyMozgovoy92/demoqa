import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class FormTest  extends TestBase {

    @Test
    void successfulFillFormTest() {
        Selenide.open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('#fixedban').remove()");1
        Selenide.executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alexey");
        $("#lastName").setValue("Mzg");
        $("#userEmail").setValue("mzg@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1357924680");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1992")).click();
        $(".react-datepicker__month-select").$(byText("June")).click();
        $(".react-datepicker__day--030").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbies-checkbox-2").parent().click();

        $("#hobbies-checkbox-1").parent().click();
        // $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("images/aleksei.jpg");
        $("#currentAddress").setValue("Baker Street, 221B");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();


        $(".modal-body").shouldHave(text("Alexey"), text("Mzg"),
                text("mzg@gmail.com"), text("Male"), text("1357924680"),
                text(30 + " " + "June" + "," + 1992),
                text("Physics"), text("Music"), text("Sports"),text("Reading"),
                text("aleksei.jpg"), text("Baker Street, 221B"),
                text("Haryana" + " " + "Karnal"));

    }
}
