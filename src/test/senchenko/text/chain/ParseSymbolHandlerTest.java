package test.senchenko.text.chain;

import com.senchenko.composite.chain.ParseSymbolHandler;
import com.senchenko.composite.composite.Component;
import com.senchenko.composite.composite.ComponentType;
import com.senchenko.composite.composite.TextComposite;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParseSymbolHandlerTest {
    ParseSymbolHandler parseSymbolHandler;
    String transferableText;
    Component component;
    @BeforeMethod
    public void setUp(){
        parseSymbolHandler = new ParseSymbolHandler();
        transferableText = "abc";
        component = new TextComposite(ComponentType.SYMBOL);
    }
    @AfterMethod
    public void tearDown(){
        parseSymbolHandler = null;
        transferableText = null;
        component = null;
    }
    @Test
    public void testHandleRequestSplitter(){
        int expected = 3;
        parseSymbolHandler.handleRequest(component, transferableText);
        int actual = component.getListComponents().size();
        Assert.assertEquals(actual,expected);
    }
}