package ada.wm2.libraryapp.helper;

public class PersonHelper {

    public static String containsFOrMLetter(String gender) throws NullPointerException, IllegalArgumentException{
        if(gender == null){
            throw new NullPointerException("Gender cannot be empty!");
        }
        else if(gender!="F" && gender!="M"){
            throw new IllegalArgumentException("Gender can only be represented by F or M");
        }
        
        return gender;

    }
}
