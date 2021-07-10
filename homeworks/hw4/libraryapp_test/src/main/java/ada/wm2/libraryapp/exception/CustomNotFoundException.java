package ada.wm2.libraryapp.exception;

public class CustomNotFoundException extends RuntimeException {

    private String message;

    public CustomNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
