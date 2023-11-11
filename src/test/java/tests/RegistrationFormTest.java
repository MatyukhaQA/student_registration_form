package tests;

import org.junit.jupiter.api.Test;
import tests.data.TestData;
import tests.pages.RegistrationPage;

public class RegistrationFormTest extends TestBase{
    RegistrationPage RegistrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void formTest() {
        RegistrationPage.openPage()
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
        RegistrationPage.checkTitle(testData.successTitle)
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
    void minimalFormFilling() {
       RegistrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .pressSubmit();
        RegistrationPage.checkTitle(testData.successTitle)
                .checkResult("Student Name", testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber);
    }

    @Test
    void incorrectFormFilling() {
        RegistrationPage.openPage()
                .removeBanners()
                .pressSubmit();
        RegistrationPage.checkBorderColors(testData.borderColor, testData.color);
    }
}