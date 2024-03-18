package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SoftAssertionsContentChecks {

    @Test
    void JUnit5ExampleExistsInSoftAssertions(){
        // open the Selenide page
        open("https://github.com/selenide/selenide");
        // click on Wiki tab
        $("a#wiki-tab").click();

        // search for soft assertions page
        $("#wiki-pages-filter").setValue("SoftAssertions");
        // click on the Soft Assertions page
        $(byAttribute("data-filterable-for", "wiki-pages-filter")).$(byTagAndText("a", "SoftAssertions")).click();

        // check that the JUnit5 example exists
        $(withTagAndText("h4","Using JUnit5 extend test class")).should(exist);
        $("#wiki-body").shouldHave(text("""
               @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }"""));
   }
}
