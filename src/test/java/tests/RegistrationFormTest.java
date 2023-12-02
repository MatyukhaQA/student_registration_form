package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.data.TestData;
import tests.pages.RegistrationPage;

public class RegistrationFormTest extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    @DisplayName("Проверка заполнения всех полей в форме")
    @Tag("Regress")
    void formTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .selectPicture(testData.picture)
                .setCurrentAddress(testData.streetAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .pressSubmit();
        registrationPage.checkTitle(testData.successTitle)
                .checkResult("Student Name", testData.firstName)
                .checkResult("Student Name", testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.streetAddress)
                .checkResult("State and City", testData.state)
                .checkResult("State and City", testData.city);
    }

    @Test
    @DisplayName("Проверка заполнения обязательных полей в форме")
    @Tag("Regress")
    void minimalFormFilling() {
       registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .pressSubmit();
        registrationPage.checkTitle(testData.successTitle)
                .checkResult("Student Name", testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber);
    }

    @Test
    @DisplayName("Отправка пустой формы")
    @Tag("Regress")
    void incorrectFormFilling() {
        registrationPage.openPage()
                .removeBanners()
                .pressSubmit();
        registrationPage.checkBorderColors(testData.borderColor, testData.color);
    }
}