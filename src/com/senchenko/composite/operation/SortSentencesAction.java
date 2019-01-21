package com.senchenko.composite.operation;

import com.senchenko.composite.composite.Component;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class SortSentencesAction {
    private static Logger logger = LogManager.getLogger();

    public List<Component> sortByLexemeCount(Component text){
        List<Component> sortedListSentences = new ArrayList<>();
        for (Component paragraph: text.getListComponents()) {
            sortedListSentences.addAll(paragraph.getListComponents());
        }
        sortedListSentences.sort(TextComparator.sortSentencesByLexemeCount());
        for (Component sentence: sortedListSentences){
            logger.log(Level.INFO, String.format("Sentence: %s", sentence.getListComponents()));
        }
        return sortedListSentences;
    }
}
