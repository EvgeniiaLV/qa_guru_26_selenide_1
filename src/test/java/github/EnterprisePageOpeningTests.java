package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class EnterprisePageOpeningTests {

    @Test
    void testSuccessfulOpenEnterprisePage() {

        open("https://github.com/");
        $(withTagAndText("button","Solutions")).hover();
        $(byAttribute("aria-labelledby", "solutions-for-heading")).$(byTagAndText("a", "Enterprise")).click();
        Selenide.webdriver().driver().url().equalsIgnoreCase("https://github.com/enterprise");
        $("#hero-section-brand-heading").shouldHave(text("""
                                                                       The AI-powered
                                                                       developer platform.
                                                                       """));
    }
}
