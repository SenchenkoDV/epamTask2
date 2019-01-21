package com.senchenko.composite.composite;

import java.util.List;

public class Symbol implements Component {
    private char value;
    private ComponentType componentType;

    public Symbol(char value, ComponentType componentType) {
        this.value = value;
        this.componentType = componentType;
    }

    @Override
    public String collectText() {
        return String.valueOf(value);
    }

    @Override
    public boolean add(Component component) {
        return false;
    }

    @Override
    public List<Component> getListComponents() {
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
