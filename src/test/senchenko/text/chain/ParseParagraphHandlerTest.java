package test.senchenko.text.chain;

import com.senchenko.composite.chain.ParseParagraphHandler;
import com.senchenko.composite.composite.Component;
import com.senchenko.composite.composite.ComponentType;
import com.senchenko.composite.composite.TextComposite;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParseParagraphHandlerTest {
    ParseParagraphHandler parseParagraphHandler;
    String transferableText;
    Component component;
    @BeforeMethod
    public void setUp() throws Exception {
        parseParagraphHandler = new ParseParagraphHandler();
        transferableText = "test1\ttest2\ttest3";
        component = new TextComposite(ComponentType.PARAGRAPH);
    }
    @AfterMethod
    public void tearDown() throws Exception {
        parseParagraphHandler = null;
        transferableText = null;
        component = null;
    }
    @Test
    public void testHandleRequestSplitter() throws Exception {
        int expected = 3;
        parseParagraphHandler.handleRequest(component, transferableText);
        int actual = component.getListComponents().size();
        Assert.assertEquals(actual,expected);
    }
}