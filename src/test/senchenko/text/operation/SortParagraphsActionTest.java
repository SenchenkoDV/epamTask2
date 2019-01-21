package test.senchenko.text.operation;

import com.senchenko.composite.composite.Component;
import com.senchenko.composite.composite.ComponentType;
import com.senchenko.composite.composite.TextComposite;
import com.senchenko.composite.operation.SortParagraphsAction;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortParagraphsActionTest {
    SortParagraphsAction sortParagraphsAction;
    Component text;
    Component paragraph1;
    Component paragraph2;
    Component paragraph3;
    Component sentence;
    @BeforeMethod
    public void setUp(){
        sortParagraphsAction = new SortParagraphsAction();
        text = new TextComposite(ComponentType.TEXT);
        paragraph1 = new TextComposite(ComponentType.PARAGRAPH);
        paragraph2 = new TextComposite(ComponentType.PARAGRAPH);
        paragraph3 = new TextComposite(ComponentType.PARAGRAPH);
        sentence = new TextComposite(ComponentType.SENTENCE);
        text.add(paragraph1);
        text.add(paragraph2);
        text.add(paragraph3);
        paragraph1.add(sentence);
        paragraph1.add(sentence);
        paragraph2.add(sentence);
        paragraph3.add(sentence);
        paragraph3.add(sentence);
        paragraph3.add(sentence);
    }
    @AfterMethod
    public void tearDown(){
        sortParagraphsAction = null;
        text = null;
        paragraph1 = null;
        paragraph2 = null;
        paragraph3 = null;
        sentence = null;
    }

    @Test
    public void testBySentenceCount(){
        int expected = 1;
        int actual = sortParagraphsAction.sortBySentenceCount(text).get(0).getListComponents().size();
        Assert.assertEquals(actual,expected);
    }
}