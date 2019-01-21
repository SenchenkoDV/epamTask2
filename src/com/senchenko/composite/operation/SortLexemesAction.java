package com.senchenko.composite.operation;

import com.senchenko.composite.composite.Component;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class SortLexemesAction {
    private static Logger logger = LogManager.getLogger();

    public List<Component> sortBySymbolOccurrenceAndAbc(Component text, char searchedSymbol){
        List<Component> sortedListLexemes = new ArrayList<>();
        for (Component paragraph: text.getListComponents()) {
            for (Component sentence: paragraph.getListComponents()){
                sortedListLexemes.addAll(sentence.getListComponents());
            }
        }
        sortedListLexemes.sort(TextComparator.sortLexemeBySymbolOccurrence(searchedSymbol).reversed()
                .thenComparing(TextComparator.sortLexemeByAbc()));
        for (Component lexeme: sortedListLexemes){
            logger.log(Level.INFO, String.format("Lexeme: %s", lexeme.collectText()));
        }
        return sortedListLexemes;
    }
}
