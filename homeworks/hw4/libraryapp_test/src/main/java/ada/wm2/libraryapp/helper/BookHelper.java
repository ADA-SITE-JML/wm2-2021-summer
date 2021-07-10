package ada.wm2.libraryapp.helper;

public class BookHelper {
    public static String minSizeOfDescr(String sizeOfDescription) throws NullPointerException, IllegalArgumentException{

        if (sizeOfDescription == null) {
            throw new NullPointerException("Description cannot be empty!");
        }
        else if (sizeOfDescription.length() < 10) {
            throw new IllegalArgumentException("Description cannot contain less than 10 characters!");
        }

        return sizeOfDescription;

    }

    public static String authorContainsDigit(String author){

        if (author == null) {
            throw new NullPointerException("Author cannot be empty!");
        }
        else if (author.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Author name cannot contain a digit");
        }

        return author;

    }
}
