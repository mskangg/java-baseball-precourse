package utils;

public class ValidationUtils {
    public static final int MIN = 1;
    public static final int MAX = 9;

    public static boolean validNo(int i) {
        return MIN <= i && i <= MAX;
    }
}
