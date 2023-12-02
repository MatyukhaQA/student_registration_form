package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.pages.components.DataPicker;
import tests.pages.components.TableResults;

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

    @Step("��������� �������� � ������")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("������� �������")
    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("������ ���")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("������ �������")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("������ email")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("�������� ���")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("������ �������")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("�������� ���� ��������")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        dataPicker.setDate(day, month, year);
        return this;
    }

    @Step("�������� �������� ���������")
    public RegistrationPage setSubjects(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }

    @Step("�������� �����")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("��������� ��������")
    public RegistrationPage selectPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("������ �����")
    public RegistrationPage setCurrentAddress(String value) {
        inputCurrentAddress.setValue(value);
        return this;
    }

    @Step("�������� ����")
    public RegistrationPage setState(String value) {
        state.click();
        state.$(byText(value)).click();
        return this;
    }

    @Step("�������� �����")
    public RegistrationPage setCity(String value) {
        city.click();
        city.$(byText(value)).click();
        return this;
    }

    @Step("������� �� ������ submit")
    public void pressSubmit() {
        submitButton.click();
    }

    @Step("��������� Title")
    public RegistrationPage checkTitle(String value) {
        title.shouldHave(text(value));
        return this;
    }

    @Step("��������� ����������� �����")
    public RegistrationPage checkResult(String key, String value) {
        tableResults.tableResults(key, value);
        return this;
    }

    @Step("��������� ��������� ��� ������������� �����")
    public void checkBorderColors(String key, String value) {
        firstNameInput.shouldHave(cssValue(key, value));
        lastNameInput.shouldHave(cssValue(key, value));
    }
}