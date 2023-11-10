package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.DataPicker;
import pages.components.TableResults;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjects = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            inputCurrentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submitButton = $("#submit"),
            title = $("#example-modal-sizes-title-lg");

    DataPicker dataPicker = new DataPicker();
    TableResults tableResults = new TableResults();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        dataPicker.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage selectPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        inputCurrentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        state.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        city.$(byText(value)).click();
        return this;
    }

    public void pressSubmit() {
        submitButton.click();
    }

    public RegistrationPage checkTitle(String value) {
        title.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableResults.tableResults(key, value);
        return this;
    }

    public void checkBorderColors(String key, String value) {
        firstNameInput.shouldHave(cssValue(key, value));
        lastNameInput.shouldHave(cssValue(key, value));
    }
}