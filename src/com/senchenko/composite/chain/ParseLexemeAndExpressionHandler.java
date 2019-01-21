package com.senchenko.composite.chain;

import com.senchenko.composite.composite.Component;
import com.senchenko.composite.composite.ComponentType;
import com.senchenko.composite.composite.TextComposite;
import com.senchenko.composite.util.ScriptCalculation;
import javax.script.ScriptException;
import java.util.Arrays;
import java.util.List;

public class ParseLexemeAndExpressionHandler implements Handler {
    private static final  String EXPRESSION = "[^\\.?]+[|&><][^\\.?]+";
    private static final String SPACE = "\\s";
    private Handler successor = new ParseSymbolHandler();

    @Override
    public void handleRequest(Component component, String text){
        List<String> list = Arrays.asList(text.trim().split(SPACE));
        for (String element : list) {
            if (element.matches(EXPRESSION) == true){
                Component childComponent = new TextComposite(ComponentType.EXPRESSION);
                component.add(childComponent);
                try {
                    successor.handleRequest(childComponent, ScriptCalculation.calculateExpression(element));
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
            }else {
                Component childComponent = new TextComposite(ComponentType.LEXEME);
                component.add(childComponent);
                successor.handleRequest(childComponent, element);
            }
        }
    }
}
