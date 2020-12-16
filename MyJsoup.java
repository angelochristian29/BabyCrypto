package Final;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


/**
 * This class gets the current value of BitCoin
 * @author Christian Hernandez
 * @version 3.0
 */
public class MyJsoup {
    static double valueBTC;
    static double valueXRP;
    /**
     * Fetches current value of BitCoin
     */
    static void getBitValue() {
        final String url = "https://www.marketwatch.com/investing/cryptocurrency/btcusd";
        try {
            final Document bitDoc = Jsoup.connect(url).get();
            Elements box = bitDoc.select("bg-quote.value");
            final String tempPrice = box.select("bg-quote.value").text();
            final String tempPrice1 = tempPrice.replace(",", "");
            valueBTC = Double.parseDouble(tempPrice1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Fetches current value if XRP
     */
    static void getXRPValue() {
        final String url = "https://www.marketwatch.com/investing/cryptocurrency/xrpusd?iso=kraken";
        try {
            final Document XRPDoc = Jsoup.connect(url).get();
            Elements box = XRPDoc.select("bg-quote.value");
            final String tempPrice = box.select("bg-quote.value").text();
            final String tempPrice1 = tempPrice.replace(",", "");
            valueXRP = Double.parseDouble(tempPrice1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}