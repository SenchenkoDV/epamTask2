package com.senchenko.composite.chain;

import com.senchenko.composite.composite.Component;
import com.senchenko.composite.composite.ComponentType;
import com.senchenko.composite.composite.TextComposite;
import java.util.Arrays;
import java.util.List;

public class ParseParagraphHandler implements Handler{
    private Handler successor = new ParseSentenceHandler();
    private static final String SEPARATOR = "\\t";

    @Override
    public void handleRequest(Component component, String text){
        List<String> list = Arrays.asList(text.trim().split(SEPARATOR));
        for (String element : list) {
                Component childComponent = new TextComposite(ComponentType.PARAGRAPH);
                component.add(childComponent);
                successor.handleRequest(childComponent, element);
        }
    }
}
