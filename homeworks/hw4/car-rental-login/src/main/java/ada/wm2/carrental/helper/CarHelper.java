package ada.wm2.carrental.helper;

public class CarHelper {

    public static Integer getCarAge(Integer year) {
        if (year == null)
            throw new NullPointerException("Year cannot be null!");
        if (year <= 0)
            throw new IllegalArgumentException("Year must be positive!");
        return 2021 - year;
    }
}
