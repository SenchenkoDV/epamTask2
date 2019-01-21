package test.senchenko.text.operation;

import com.senchenko.composite.composite.Component;
import com.senchenko.composite.composite.ComponentType;
import com.senchenko.composite.composite.TextComposite;
import com.senchenko.composite.operation.SortSentencesAction;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortSentencesActionTest {
    SortSentencesAction sortSentencesAction;
    Component text;
    Component paragraph;
    Component sentence1;
    Component sentence2;
    Component sentence3;
    Component lexeme;
    @BeforeMethod
    public void setUp(){
        sortSentencesAction = new SortSentencesAction();
        text = new TextComposite(ComponentType.TEXT);
        paragraph = new TextComposite(ComponentType.PARAGRAPH);
        sentence1 = new TextComposite(ComponentType.SENTENCE);
        sentence2 = new TextComposite(ComponentType.SENTENCE);
        sentence3 = new TextComposite(ComponentType.SENTENCE);
        lexeme = new TextComposite(ComponentType.LEXEME);
        text.add(paragraph);
        paragraph.add(sentence1);
        paragraph.add(sentence2);
        paragraph.add(sentence3);
        sentence1.add(lexeme);
        sentence1.add(lexeme);
        sentence2.add(lexeme);
        sentence3.add(lexeme);
        sentence3.add(lexeme);
        sentence3.add(lexeme);
    }
    @AfterMethod
    public void tearDown(){
        sortSentencesAction = null;
        text = null;
        paragraph = null;
        sentence1 = null;
        sentence2 = null;
        sentence3 = null;
        lexeme = null;
    }
    @Test
    public void testSortByLexemeCount(){
        int expected = 1;
        int actual = sortSentencesAction.sortByLexemeCount(text).get(0).getListComponents().size();
        Assert.assertEquals(actual,expected);
    }
}