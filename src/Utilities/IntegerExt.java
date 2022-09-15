package Utilities;

public  class IntegerExt {
    public static boolean isParsable(String stringa){
        try{Integer.parseInt(stringa);
        return true;}
        catch(NumberFormatException e) {return false;}
    }
}
