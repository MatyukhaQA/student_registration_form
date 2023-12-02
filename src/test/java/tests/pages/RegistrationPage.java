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

    @Step("Открываем страницу с формой")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Удаляем баннеры")
    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Вводим имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Вводим фамилию")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Вводим email")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Выбираем пол")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Вводим телефон")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Выбираем дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        dataPicker.setDate(day, month, year);
        return this;
    }

    @Step("Выбираем названия предметов")
    public RegistrationPage setSubjects(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Загружаем картинку")
    public RegistrationPage selectPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Вводим адрес")
    public RegistrationPage setCurrentAddress(String value) {
        inputCurrentAddress.setValue(value);
        return this;
    }

    @Step("Выбираем штат")
    public RegistrationPage setState(String value) {
        state.click();
        state.$(byText(value)).click();
        return this;
    }

    @Step("Выбираем город")
    public RegistrationPage setCity(String value) {
        city.click();
        city.$(byText(value)).click();
        return this;
    }

    @Step("Кликаем по кнопке submit")
    public void pressSubmit() {
        submitButton.click();
    }

    @Step("Проверяем Title")
    public RegistrationPage checkTitle(String value) {
        title.shouldHave(text(value));
        return this;
    }

    @Step("Проверяем заполненную форму")
    public RegistrationPage checkResult(String key, String value) {
        tableResults.tableResults(key, value);
        return this;
    }

    @Step("Проверяем валидацию при незаполненной форме")
    public void checkBorderColors(String key, String value) {
        firstNameInput.shouldHave(cssValue(key, value));
        lastNameInput.shouldHave(cssValue(key, value));
    }
}