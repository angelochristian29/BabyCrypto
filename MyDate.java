package Final;


import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
/**
 * This program gets the current date when it's run
 * @author Christian Hernandez
 * @version 3.0
 */
public class MyDate {
    
    static String strDate; 
    /**
     * Returns date as string
     */
    public static void currentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        strDate = dtf.format(now);
    }
    
}
