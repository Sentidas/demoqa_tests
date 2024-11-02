package guru.qa.data;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class DataGeneration {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            userPhone = faker.phoneNumber().subscriberNumber(10),
            userGender = faker.options().option("Male", "Female", "Other"),
            currentAddress = faker.address().fullAddress(),
            calendarDay = String.format("%s",faker.number().numberBetween(1,28)),
            calendarMoth = faker.options().option("December","January","February",
                    "March","April","May","June",
                    "July", "August","September",
                    "October","November"),
            calendarYear = String.format("%s", faker.number().numberBetween(1980,2020)),
            userSubjects = faker.options().option("Maths","Chemistry","English",
                    "Computer Science"),
            userHobbies = faker.options().option("Sports", "Reading", "Music"),
            userState = faker.options().option("NCR", "Uttar Pradesh","Haryana", "Rajasthan"),
            userCity = getRandomCity(userState);


    @Step("Генерация случайных данных")
    public String getRandomCity(String userState) {
        if (userState.equals( "NCR")) userCity = faker.options().option("Delhi","Gurgaon","Noida");
        if (userState.equals("Uttar Pradesh")) userCity = faker.options().option("Agra","Lucknow","Merrut");
        if (userState.equals("Haryana")) userCity = faker.options().option("Karnal","Panipat");
        if (userState.equals("Rajasthan")) userCity = faker.options().option("Jaipur","Jaiselmer");
        return userCity;
    }



}
