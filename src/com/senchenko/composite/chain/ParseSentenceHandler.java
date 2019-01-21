package com.senchenko.composite.chain;

import com.senchenko.composite.composite.Component;
import com.senchenko.composite.composite.ComponentType;
import com.senchenko.composite.composite.TextComposite;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseSentenceHandler implements Handler {
    private static final String TEXT = "[^\\.?]+[!.?]?+\\s*?";
    private static Handler successor = new ParseLexemeAndExpressionHandler();

    @Override
    public void handleRequest(Component component, String text){
        List<String> list = new ArrayList<>();
        Pattern sentencePattern = Pattern.compile(TEXT);
        Matcher sentenceMatcher = sentencePattern.matcher(text);
        while (sentenceMatcher.find()){
            String s = sentenceMatcher.group();
            list.add(s);
        }
        for (String element : list) {
                Component childComponent = new TextComposite(ComponentType.SENTENCE);
                component.add(childComponent);
                successor.handleRequest(childComponent, element);
        }
    }
}
