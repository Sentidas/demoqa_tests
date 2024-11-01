package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Tag("demoqa")
public class SimpleTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
       // Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; //default 4000
    }

    @Test
    public void fillSimpleForm() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/text-box");
        $("#userName").setValue("Lena");
       // $("[id=userName]").setValue("Lena");
       // $(by("id", "userName")).setValue("Lena");
       //$(byId("userName")).setValue("Lena");
       //$x("//*[@id='userName'").setValue("Lena");

        $("#userEmail").setValue("Lena@lena.ru");
        $("#currentAddress").setValue("Volgograd");
        $("#permanentAddress").setValue("Italia");
        $("#submit").click();

        $("#output #name").shouldHave(text("Leedgdegna"));
        $("#output #email").shouldHave(text("Lena@lena.ru"));
        $("#output #currentAddress").shouldHave(text("Volgograd"));
        $("#output #permanentAddress").shouldHave(text("Italia"));

    }
}
