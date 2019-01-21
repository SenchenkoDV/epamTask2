package com.senchenko.composite.chain;

import com.senchenko.composite.composite.Component;
import com.senchenko.composite.composite.ComponentType;
import com.senchenko.composite.composite.Symbol;
import java.util.Arrays;
import java.util.List;

public class ParseSymbolHandler implements Handler {
    private static final String SEPARATOR = "";
    private static final int FIRST_SYMBOL = 0;

    @Override
    public void handleRequest(Component component, String text) {
        List<String> list = Arrays.asList(text.trim().split(SEPARATOR));
        for (String element : list) {
                Component childComponent = new Symbol(element.charAt(FIRST_SYMBOL), ComponentType.SYMBOL);
                component.add(childComponent);
        }
    }
}
