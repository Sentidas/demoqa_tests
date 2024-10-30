import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; //default 4000
    }

    @Test
    public void fillSimpleForm() {
        open("/text-box");
        $("#userName").setValue("Lena");
        $("#userEmail").setValue("Lena@lena.ru");
        $("#currentAddress").setValue("Volgograd");
        $("#permanentAddress").setValue("Italia");
        $("#submit").click();

        $("#output #name").shouldHave(text("Lena"));
        $("#output #email").shouldHave(text("Lena@lena.ru"));
        $("#output #currentAddress").shouldHave(text("Volgograd"));
        $("#output #permanentAddress").shouldHave(text("Italia"));

    }
}
