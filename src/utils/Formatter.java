package utils;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Formatter {
    public static String formatDateTime(LocalDateTime date){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return date.format(myFormatObj);
    }

    public static String formatNumber(double number){
        NumberFormat myFormat = NumberFormat.getInstance(Locale.US);
        return myFormat.format(number) + "đ";
    }
}
