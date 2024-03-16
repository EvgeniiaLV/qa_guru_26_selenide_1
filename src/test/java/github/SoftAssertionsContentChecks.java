package github;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SoftAssertionsContentChecks {

    @Test
    void JUnit5ExampleExistsInSoftAssertions(){
        // open the Selenide page
        open("https://github.com/selenide/selenide");
        // open Wiki tab
        $("a#wiki-tab").click();

        // search for soft assertions page
        $("#wiki-pages-filter").setValue("SoftAssertions");
        // click on the Soft Assertions page
        $(byAttribute("data-filterable-for", "wiki-pages-filter")).$(byTagAndText("a", "SoftAssertions")).click();

        // check that JUnit5 example exists
        $(withTagAndText("h4","Using JUnit5 extend test class")).should(exist);
    }
}
