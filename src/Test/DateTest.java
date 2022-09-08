package Test;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        java.sql.Date date = new java.sql.Date(new Date().getTime());
        System.out.println(date);
        long millis = System.currentTimeMillis();
        System.out.println(date);
    }
}
