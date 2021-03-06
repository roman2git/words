/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.webstones.words;

import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author jaroslav_b
 */
public class ServiceTest {
    
    @Test
    public void testSetup() throws IOException {
        Setup s = Service.getSetup(false);
        assertEquals("Data dir:", "Data", s.getDataDir());
        assertEquals("MP3 dir:", "MP3", s.getMp3Dir());
        assertEquals("Dictionary file:", "Dictionary.txt", s.getDirectoryFile());
        assertEquals("Category file:", "Categories.txt", s.getCategoryFile());
        assertEquals("Dictionary separator:", ";", s.getDictionarySeparator());
        assertEquals("Dictionary date format:", "dd.MM.yyyy HH:mm", s.getDictionaryDateFormat());
        assertEquals("Full dictionary path:", "Data/Dictionary.txt", s.getFullDictionaryFilePath());
        assertEquals("Full category path:", "Data/Categories.txt", s.getFullCategoryFilePath());
        assertEquals("Full MP3 dir path:", "Data/MP3", s.getFullMp3Path());
    }
    
    @Test
    public void testCleanAndAddSeparator() throws IOException {
        assertEquals("Bad string 1", "Ahoj;", Service.cleanAndAddSeparator(" Ah;oj ", ";"));
        assertEquals("Bad string 2", "Ahoj;", Service.cleanAndAddSeparator("Ahoj ;", ";"));
        assertEquals("Bad string 3", "Ahoj;", Service.cleanAndAddSeparator(" ;Ahoj", ";"));
        assertEquals("Bad string 4", "Ahoj;", Service.cleanAndAddSeparator(";Ah;;o;j; ; ", ";"));
    }
}
