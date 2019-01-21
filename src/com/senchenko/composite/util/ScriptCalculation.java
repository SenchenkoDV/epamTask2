package com.senchenko.composite.util;

import javax.script.*;

public class ScriptCalculation {
    private static final String ENGINE = "JavaScript";

    public static String calculateExpression(String expression) throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine javaScriptEngine = scriptEngineManager.getEngineByName(ENGINE);
        return javaScriptEngine.eval(expression).toString();
    }
}
