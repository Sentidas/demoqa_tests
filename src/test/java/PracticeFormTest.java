import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillPracticeForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivan@ivanov.ru");
        $("#userNumber").setValue("78882223344");
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Male")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--025").click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("hello.png");
        $("#currentAddress").setValue("Rostov");
        $(("#react-select-3-input")).scrollTo();
        $(("#react-select-3-input")).setValue("Haryana").pressEnter();
        $(("#react-select-4-input")).setValue("Karnal").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("Ivan@ivanov.ru"));
        $(".table-responsive").shouldHave(text("Ivan@ivanov.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("25 May,1998"));
        $(".table-responsive").shouldHave(text("hello.png"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("Rostov"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));










    }
}
