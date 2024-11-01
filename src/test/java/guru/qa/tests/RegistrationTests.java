package guru.qa.tests;

import guru.qa.data.DataGeneration;
import org.junit.jupiter.api.Test;
import guru.qa.pages.RegistrationPage;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    DataGeneration data = new DataGeneration();

    @Test
    void fillRegistration() {

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setUserNumber(data.userPhone)
                .chooseGender(data.userGender)
                .setDateOfBirth(data.calendarDay, data.calendarMoth, data.calendarYear)
                .setSubject(data.userSubjects)
                .selectHobbies(data.userHobbies)
                .uploadPicture("img/hello.png")
                .setCurrentAddress(data.currentAddress)
                .selectStateAndCity(data.userState,data.userCity)
                .submitForm()

                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.userGender)
                .checkResult("Mobile", data.userPhone)
                .checkResult("Date of Birth", data.calendarDay + " " + data.calendarMoth + "," + data.calendarYear)
                .checkResult("Subjects", data.userSubjects)
                .checkResult("Hobbies", data.userHobbies)
                .checkResult("Picture", "hello.png")
                .checkResult("Address", data.currentAddress)
                .checkResult("State and City", data.userState + " " + data.userCity);
    }
    @Test
    void registrationWithMinData() {

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setUserNumber(data.userPhone)
                .chooseGender(data.userGender)
                .submitForm()

                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Gender", data.userGender)
                .checkResult("Mobile", data.userPhone);

    }

    @Test
    void negativeRegistration() {

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .chooseGender(data.userGender)
                .submitForm()
                .checkFormControl();


    }
}
