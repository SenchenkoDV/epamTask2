package test.senchenko.text.reader;

import com.senchenko.composite.reader.DataFileReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataFileReaderTest {
    DataFileReader dataFileReader;
    String expectedString;
    String falsePath = "textData.txt";
    @BeforeMethod
    public void setUp(){
        dataFileReader = new DataFileReader();
        expectedString = "    It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 3>>5 essentially 6&9|(3&4) unchanged. It was popularised in the 5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
                "\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here, making it look like readable English." +
                "\tIt is a (8^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout." +
                "\tBye.";
    }
    @AfterMethod
    public void tearDown(){
        dataFileReader = null;
        expectedString = null;
        falsePath = null;
    }

    @Test
    public void testReadFromDefaultPath() throws Exception {
        String expected = expectedString;
        String actual = dataFileReader.read(falsePath);
        Assert.assertEquals(actual,expected);
    }
}