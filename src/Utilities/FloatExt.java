package Utilities;

public class FloatExt {
    public static boolean isParsable(String stringa) {
        try {
            Float.parseFloat(stringa);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}