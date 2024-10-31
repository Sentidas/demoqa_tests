package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillPracticeForm() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("Ivan@ivanov.ru")
                .setUserNumber("78882223344")
                .chooseGender("Male")
                .setDateOfBirth("29", "May", "1998")
                .setSubject("English")
                .selectHobbies("Reading")
                .uploadPicture("img/hello.png")
                .setCurrentAddress("Some address 1")
                .selectStateAndCity("Haryana","Karnal" )
                .submitForm()

                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "Ivan@ivanov.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "Mobile 7888222334")
                .checkResult("Date of Birth", "Date of Birth 29 May,1998")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "hello.png")
                .checkResult("Address", "Some address 1")
                .checkResult("State and City", "Haryana Karnal");
    }
    @Test
    void fillPracticeFormWithMinData() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("Ivan@ivanov.ru")
                .setUserNumber("78882223344")
                .chooseGender("Male")
                .submitForm()

                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "Ivan@ivanov.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "Mobile 7888222334");

    }

    @Test
    void negativePracticeFormWithMinData() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName(" ")
                .setEmail("Ivan@ivanov.ru")
                .setUserNumber("78882223344")
                .chooseGender("Male")
                .submitForm()

                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "Ivan@ivanov.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "Mobile 7888222334");

    }
}
