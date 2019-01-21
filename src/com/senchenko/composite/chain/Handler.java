package com.senchenko.composite.chain;

import com.senchenko.composite.composite.Component;

public interface Handler {
     void handleRequest(Component component, String list);
}
