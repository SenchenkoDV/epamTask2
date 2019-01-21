package com.senchenko.composite.reader;

import com.senchenko.composite.exception.TextException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataFileReader {
    private static Logger logger = LogManager.getLogger();
    private final static String DEFAULT_PATH = "input/input.txt";
    private static String path = DEFAULT_PATH;
    private static String inputText;

    public String read(String retrievedPath) throws TextException {
        if ((new File(retrievedPath)).exists()) {
            path = retrievedPath;
        }
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            inputText = stream.collect(Collectors.joining());
        } catch (IOException e) {
            throw new TextException(e);
        }
        logger.log(Level.INFO, String.format("Was read composite: %s", inputText));
        return inputText;
    }
}
