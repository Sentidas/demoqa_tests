package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final  SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genderWrapper= $("#genterWrapper"),
            subjectInput= $("#subjectsInput"),
            calendarInput= $("#dateOfBirthInput"),
            hobbiesInput=$("#hobbiesWrapper"),
            currentAddress= $("#currentAddress"),
            stateInput= $("#state"),
            stateCityWrapper= $("#stateCity-wrapper"),
            cityInput= $("#city"),
            submitButton= $("#submit"),
            tableResponsive =       $(".table-responsive"),
            formWrapper = $(".practice-form-wrapper"),
            pathFile=$("#uploadPicture");

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открытие страницы")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }
    @Step("Ввод имени {firstName}")
    public RegistrationPage setFirstName (String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    @Step("Ввод фамилии {lastName}")
    public RegistrationPage setLastName (String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    @Step("Ввод email {email}")
    public RegistrationPage setEmail (String email) {
        userEmailInput.setValue(email);
        return this;
    }

    @Step("Ввод номера телефона {mobileNumber}")
    public RegistrationPage setUserNumber(String mobileNumber) {
        userNumberInput.setValue(mobileNumber);
        return this;
    }

    @Step("Выбор пола {gender}")
    public RegistrationPage chooseGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    @Step("Ввод даты рождения {day}.{month}.{year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
         return this;
    }

    @Step("Выбор предмета {subject}")
    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбор хобби {hobbie}")
    public RegistrationPage selectHobbies(String hobbie) {
        hobbiesInput.$(byText(hobbie)).click();
        return this;
    }

    @Step("Выбор фото по адресу {path}")
    public RegistrationPage uploadPicture(String path) {
        pathFile.uploadFromClasspath(path);
        return this;
    }

    @Step("Ввод адреса {address}")
    public RegistrationPage setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    @Step("Выбор штата и города {state}.{city}")
    public RegistrationPage selectStateAndCity(String state, String city) {
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(state)).click();
        cityInput.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    @Step("Нажатие на кнопку подтверждения")
    public RegistrationPage submitForm() {
        submitButton.scrollTo().click();
        return this;
    }

    @Step("Проверка названия страницы")
    public void checkFormControl(){
        formWrapper.shouldHave(text("Student Registration Form"));
    }
    @Step("Проверка введенных данных - {key} : {value} ")
    public RegistrationPage checkResult (String key, String value) {
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}
