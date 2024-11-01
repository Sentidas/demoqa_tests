package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

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
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName (String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName (String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail (String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setUserNumber(String mobile) {
        userNumberInput.setValue(mobile);
        return this;
    }

    public RegistrationPage chooseGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
         return this;
    }

    public RegistrationPage setSubject(String subject) {

        subjectInput.setValue(subject).pressEnter();
        return this;
    }
    public RegistrationPage selectHobbies(String hobbie) {
        hobbiesInput.$(byText(hobbie)).click();
        return this;
    }
    public RegistrationPage uploadPicture(String path) {
        pathFile.uploadFromClasspath(path);
        return this;
    }
    public RegistrationPage setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }
    public RegistrationPage selectStateAndCity(String state, String city) {
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(state)).click();
        cityInput.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.scrollTo().click();
        return this;

    }

    public void checkFormControl(){
        formWrapper.shouldHave(text("Student Registration Form"));
    }

    public RegistrationPage checkResult (String key, String value) {
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }


}
