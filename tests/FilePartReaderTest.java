import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    FilePartReader fpr = new FilePartReader();
    FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);

    @Test
    @DisplayName("Invalid initial values")
    public void testAreClassVariablesInvalid() {

        assertAll(() -> assertFalse(fpr.toLine > 0),
                () -> assertFalse(fpr.fromLine > 0),
                () -> assertFalse(fpr.filePath.equals("example.txt")));
    }

    @Test
    public void testIsToLineLessThanFromLine() {
        assertThrows(IllegalArgumentException.class, () -> {
            fpr.setup("example.txt", 2, 1);
        });
    }

    @Test
    public void testIsFromLineLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            fpr.setup("example.txt", -1, 1);
        });
    }

    @Test
    public void testReadLinesFirstLine(){
        fpr.setup("example.txt", 1,1);
        try {
            assertEquals("this is the very first line\n", fpr.readLines());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAreWordsInOrder(){
        fpr.setup("example.txt", 1,2);
        try {
            assertArrayEquals((new String[]{"2nd", "first", "inertia", "is", "line", "line", "qwewq", "the", "this", "very"}), fwa.wordsByABC().toArray() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}