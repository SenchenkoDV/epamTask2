package test.senchenko.text.composite;

import com.senchenko.composite.composite.Component;
import com.senchenko.composite.composite.ComponentType;
import com.senchenko.composite.composite.Symbol;
import com.senchenko.composite.composite.TextComposite;
import org.testng.Assert;
import org.testng.annotations.*;

public class TextCompositeTest {
    Component text;
    Component paragraph;
    Component sentence;
    Component lexeme1;
    Component lexeme2;
    Component symbol1;
    Component symbol2;
    Component symbol3;
    Component symbol4;
    @BeforeClass
    public void setUp(){
        text = new TextComposite(ComponentType.TEXT);
        paragraph = new TextComposite(ComponentType.PARAGRAPH);
        sentence = new TextComposite(ComponentType.SENTENCE);
        lexeme1 = new TextComposite(ComponentType.LEXEME);
        lexeme2 = new TextComposite(ComponentType.LEXEME);
        symbol1 = new Symbol('a', ComponentType.SYMBOL);
        symbol2 = new Symbol('b', ComponentType.SYMBOL);
        symbol3 = new Symbol('c', ComponentType.SYMBOL);
        symbol4 = new Symbol('d', ComponentType.SYMBOL);
        text.add(paragraph);
        paragraph.add(sentence);
        sentence.add(lexeme1);
        sentence.add(lexeme2);
        lexeme1.add(symbol1);
        lexeme1.add(symbol2);
        lexeme2.add(symbol3);
        lexeme2.add(symbol4);
    }
    @AfterClass
    public void tearDown(){
        text = null;
        paragraph = null;
        sentence = null;
        lexeme1 = null;
        lexeme2 = null;
        symbol1 = null;
        symbol2 = null;
        symbol3 = null;
        symbol4 = null;
    }
    @Test
    public void testGetText(){
        String expected = " ab cd";
        String actual = text.collectText();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCollectListComponents(){
        int expected = 1;
        int actual = text.getListComponents().size();
        Assert.assertEquals(actual,expected);
    }
}