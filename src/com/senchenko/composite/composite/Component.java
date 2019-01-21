package com.senchenko.composite.composite;

import java.util.List;

public interface Component {
    ComponentType componentType = ComponentType.TEXT;
    String collectText();
    boolean add(Component component);
    List<Component> getListComponents();
}
