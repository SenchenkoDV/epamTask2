package test.senchenko.text.chain;

import com.senchenko.composite.chain.ParseLexemeAndExpressionHandler;
import com.senchenko.composite.composite.Component;
import com.senchenko.composite.composite.ComponentType;
import com.senchenko.composite.composite.TextComposite;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParseLexemeAndExpressionHandlerTest {
    ParseLexemeAndExpressionHandler parseLexemeAndExpressionHandler;
    String transferableText;
    Component component;
    @BeforeMethod
    public void setUp(){
        parseLexemeAndExpressionHandler = new ParseLexemeAndExpressionHandler();
        transferableText = "test1 test2 test3";
        component = new TextComposite(ComponentType.LEXEME);
    }
    @AfterMethod
    public void tearDown(){
        parseLexemeAndExpressionHandler = null;
        transferableText = null;
        component = null;
    }
    @Test
    public void testHandleRequestSplitter(){
        int expected = 3;
        parseLexemeAndExpressionHandler.handleRequest(component, transferableText);
        int actual = component.getListComponents().size();
        Assert.assertEquals(actual,expected);
    }
}