package com.senchenko.composite.operation;

import com.senchenko.composite.composite.Component;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class SortParagraphsAction {
    private static Logger logger = LogManager.getLogger();

    public List<Component> sortBySentenceCount(Component text){
        List<Component> sortedListParagraphs = text.getListComponents();
        sortedListParagraphs.sort(TextComparator.sortParagraphsBySentenceCount());
        for (Component paragraph: sortedListParagraphs){
            logger.log(Level.INFO, String.format("Paragraph: %s", paragraph.getListComponents()));
        }
        return sortedListParagraphs;
    }
}
