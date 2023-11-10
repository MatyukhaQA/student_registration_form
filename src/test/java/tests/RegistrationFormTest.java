package tests;

import org.junit.jupiter.api.Test;
import tests.pages.RegistrationPage;

public class RegistrationFormTest extends TestBase{
    RegistrationPage RegistrationPage = new RegistrationPage();
    @Test
    void formTest() {
        RegistrationPage.openPage()
                .removeBanners()
                .setFirstName("Maria")
                .setLastName("Ivanova")
                .setEmail("ivanova@gmail.ru")
                .setGender("Female")
                .setUserNumber("9998887766")
                .setDateOfBirth("8", "March", "1990")
                .setSubjects("Chemistry")
                .setHobbies("Reading")
                .selectPicture("pic.jpg")
                .setCurrentAddress("New Delhi")
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmit();
        RegistrationPage.checkTitle("Thanks for submitting the form")
                .checkResult("Student Name", "Maria Ivanova")
                .checkResult("Student Email", "ivanova@gmail.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9998887766")
                .checkResult("Date of Birth", "08 March,1990")
                .checkResult("Subjects", "Chemistry")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "pic.jpg")
                .checkResult("Address", "New Delhi")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void minimalFormFilling() {
       RegistrationPage.openPage()
                .removeBanners()
                .setFirstName("Maria")
                .setLastName("Ivanova")
                .setEmail("ivanova@gmail.ru")
                .setGender("Female")
                .setUserNumber("9998887766")
                .pressSubmit();
        RegistrationPage.checkTitle("Thanks for submitting the form")
                .checkResult("Student Name", "Maria Ivanova")
                .checkResult("Student Email", "ivanova@gmail.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9998887766");
    }

    @Test
    void incorrectFormFilling() {
        RegistrationPage.openPage()
                .removeBanners()
                .pressSubmit();
        RegistrationPage.checkBorderColors("border-color","rgb(220, 53, 69)");
    }
}