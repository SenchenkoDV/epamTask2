package com.senchenko.composite.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
    private List<Component> components = new ArrayList<>();
    private ComponentType componentType;
    private static final String SPACE = " ";
    private static final String SEPARATOR = "";

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public String collectText() {
        String result = SEPARATOR;
        for (Component component : components) {
            result += component.collectText();
        }
        return (this.componentType == ComponentType.LEXEME) ||
                (this.componentType == ComponentType.EXPRESSION)
                ? SPACE + result : result;
    }

    @Override
    public boolean add(Component component) {
        return components.add(component);
    }

    @Override
    public List<Component> getListComponents() {
        return components;
    }
}
