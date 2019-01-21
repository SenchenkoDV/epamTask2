package test.senchenko.text.operation;

        import com.senchenko.composite.composite.Component;
        import com.senchenko.composite.composite.ComponentType;
        import com.senchenko.composite.composite.Symbol;
        import com.senchenko.composite.composite.TextComposite;
        import com.senchenko.composite.operation.SortLexemesAction;
        import org.testng.Assert;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

public class SortLexemesActionTest {
    SortLexemesAction sortLexemesAction;
    Component text;
    Component paragraph;
    Component sentence;
    Component lexeme1;
    Component lexeme2;
    Component lexeme3;
    Component transferableSymbolX;
    Component symbolA;
    Component symbolB;
    Component symbolC;
    @BeforeMethod
    public void setUp(){
        sortLexemesAction = new SortLexemesAction();
        text = new TextComposite(ComponentType.TEXT);
        paragraph = new TextComposite(ComponentType.PARAGRAPH);
        sentence = new TextComposite(ComponentType.SENTENCE);
        lexeme1 = new TextComposite(ComponentType.LEXEME);
        lexeme2 = new TextComposite(ComponentType.LEXEME);
        lexeme3 = new TextComposite(ComponentType.LEXEME);
        transferableSymbolX = new Symbol('X', ComponentType.SYMBOL);
        symbolA = new Symbol('A', ComponentType.SYMBOL);
        symbolB = new Symbol('B', ComponentType.SYMBOL);
        symbolC = new Symbol('C', ComponentType.SYMBOL);
        text.add(paragraph);
        paragraph.add(sentence);
        sentence.add(lexeme1);
        sentence.add(lexeme2);
        sentence.add(lexeme3);
        lexeme1.add(symbolB);
        lexeme1.add(transferableSymbolX);
        lexeme2.add(symbolA);
        lexeme2.add(transferableSymbolX);
        lexeme3.add(symbolC);
        lexeme3.add(transferableSymbolX);
        lexeme3.add(transferableSymbolX);
    }
    @AfterMethod
    public void tearDown(){
        sortLexemesAction = null;
        text = null;
        paragraph = null;
        sentence = null;
        lexeme1 = null;
        lexeme2 = null;
        lexeme3 = null;
        transferableSymbolX = null;
        symbolA = null;
        symbolB = null;
        symbolC = null;
    }
    @Test
    public void testSortBySymbolOccurrenceAndAbc(){
        String expected = " BX";
        String actual = sortLexemesAction.sortBySymbolOccurrenceAndAbc(text,'X').get(2).collectText();
        Assert.assertEquals(actual,expected);
    }
}