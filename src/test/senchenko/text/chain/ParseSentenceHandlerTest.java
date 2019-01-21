package test.senchenko.text.chain;

import com.senchenko.composite.chain.ParseSentenceHandler;
import com.senchenko.composite.composite.Component;
import com.senchenko.composite.composite.ComponentType;
import com.senchenko.composite.composite.TextComposite;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParseSentenceHandlerTest {
    ParseSentenceHandler parseSentenceHandler;
    String transferableText;
    Component component;
    @BeforeMethod
    public void setUp(){
        parseSentenceHandler = new ParseSentenceHandler();
        transferableText = "Abc. Abc. Abc.";
        component = new TextComposite(ComponentType.SENTENCE);
    }
    @AfterMethod
    public void tearDown(){
        parseSentenceHandler = null;
        transferableText = null;
        component = null;
    }
    @Test
    public void testHandleRequestSplitter(){
        int expected = 3;
        parseSentenceHandler.handleRequest(component, transferableText);
        int actual = component.getListComponents().size();
        Assert.assertEquals(actual,expected);
    }
}