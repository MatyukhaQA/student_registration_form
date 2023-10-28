package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1500x1000";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void FormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Alexivanov@gmail.ru");
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("9998887766");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $("[aria-label = 'Choose Thursday, March 8th, 1990']").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("label[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/pic.jpg"));
        $("#currentAddress").setValue("New Delhi");
        $("#state").click();
        $("#state input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#city input").setValue("Delhi").pressEnter();
        $("#submit").pressEnter();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Alex Ivanov"),
                text("Alexivanov@gmail.ru"),
                text("Male"),
                text("9998887766"),
                text("8 March,1990"),
                text("Chemistry"),
                text("Reading"),
                text("pic.jpg"),
                text("New Delhi"),
                text("NCR Delhi"));


    }

}
