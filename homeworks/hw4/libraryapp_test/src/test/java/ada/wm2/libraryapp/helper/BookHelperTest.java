package ada.wm2.libraryapp.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookHelperTest {


    @Test
    @DisplayName("Description is less than 10 characters")
    void testException() {
        String description = "Novel";

        assertThrows(IllegalArgumentException.class, ()->BookHelper.minSizeOfDescr(description));

    }

    @Test
    @DisplayName("Expected description character size")
    void testMinSizeOfDescr(){

        String expected_description = "Science Fiction";
        String result  = BookHelper.minSizeOfDescr(expected_description);


        assertEquals(expected_description,result);


    }

    @Test
    @DisplayName("Author name contains a digit")
    void testAuthorException() {
        String author = "George Orwell123";

        assertThrows(IllegalArgumentException.class, ()->BookHelper.authorContainsDigit(author));

    }

    @Test
    @DisplayName("Expected author name without digits")
    void testAuthorName(){

        String expected_author = "William Shakepeare";
        String result  = BookHelper.authorContainsDigit(expected_author);


        assertEquals(expected_author,result);


    }




}
