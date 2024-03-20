package github;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @Test
    void testDragAndDropMethod(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(exactText("A"));
        DragAndDropOptions.DragAndDropTarget testDragAndDropTarget = new DragAndDropOptions.DragAndDropTarget.CssSelector("#column-b");
        DragAndDropOptions.DragAndDropMethod testMethod = DragAndDropOptions.DragAndDropMethod.JS;
        DragAndDropOptions testDragAndDrop = new DragAndDropOptions(testDragAndDropTarget, testMethod);
        $("#column-a").dragAndDrop(testDragAndDrop);
        $("#column-a").shouldHave(exactText("B"));
    }

    @Test
    void testDragAndDropMoveByOffset(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(exactText("A"));
        $("#column-a").hover();
        actions().clickAndHold().moveByOffset(150, 0).release().perform();
        $("#column-a").shouldHave(exactText("B"));
    }
}
