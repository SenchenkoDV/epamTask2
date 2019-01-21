package com.senchenko.composite.operation;

import com.senchenko.composite.composite.Component;
import java.util.Comparator;

public class TextComparator {
    public static Comparator<Component> sortParagraphsBySentenceCount(){
        return Comparator.comparingInt(component -> component.getListComponents().size());
    }
    public static Comparator<Component> sortSentencesByLexemeCount(){
        return Comparator.comparingInt(component -> component.getListComponents().size());
    }
    public static Comparator<Component> sortLexemeBySymbolOccurrence(char symbol){
        return Comparator.comparingInt(lexeme -> lexeme.collectText()
                .replaceAll("[^" + String.valueOf(symbol) + "]", "").length());
    }
    public static Comparator<Component> sortLexemeByAbc(){
        return Comparator.comparing(p -> p.getListComponents().toString());
    }
}
