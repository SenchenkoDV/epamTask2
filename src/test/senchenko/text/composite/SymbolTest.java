package test.senchenko.text.composite;

import com.senchenko.composite.composite.ComponentType;
import com.senchenko.composite.composite.Symbol;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SymbolTest {
    Symbol testSymbol;
    @BeforeMethod
    public void setUp(){
        testSymbol = new Symbol('a', ComponentType.SYMBOL);
    }
    @AfterMethod
    public void tearDown(){
        testSymbol = null;
    }
    @Test
    public void testCollectText(){
        String expected = "a";
        String actual = testSymbol.collectText();
        Assert.assertEquals(actual,expected);
    }
}