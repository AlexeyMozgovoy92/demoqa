package test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class FormTestStepsWithFakerTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @Test
    void successfulFillFormTest() {
        Faker faker = new Faker();
        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().subscriberNumber(10);
        String address = faker.address().fullAddress();

        step("Открываем главную страницу" , () -> {
            registrationFormPage.openPage();
        });

        step("Заполняем ФИО, почту и тел." , () -> {
        registrationFormPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender()
                .setPhone(phone);
        });
        step("Усьанавливаем дату рождения" , () -> {
                    registrationFormPage.setDateOfBirth("30", "June", "1992");
                });
        step("Загружаем фото" , () -> {
                    registrationFormPage.uploadPicture();
                });
        step("Заполняем поля Хобби, Адрес" , () -> {
                    registrationFormPage.setSubject("Physics")
                            .setHobbies()
                            .setCurrentAddress(address)
                            .setStateAndCity();
                });
        step("Нажимаем Подтвердить" , () -> {
                    $("#submit").click();
                });
        step("Выполняем проверку на соответствие заполненных данных" , () -> {
            $(".modal-body").shouldHave(text(firstName), text(lastName),
                    text(email), text("Male"), text(phone),
                    text(30 + " " + "June" + "," + 1992),
                    text("Physics"), text("Music"), text("Sports"), text("Reading"),
                    text("aleksei.jpg"), text(address),
                    text("Haryana" + " " + "Karnal"));
        });
    }
}
