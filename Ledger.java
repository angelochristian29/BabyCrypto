package Final;


import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


/**
 * This is a class to keep track of purchases of the user
 * @author Christian Hernandez
 * @version 3.0
 */
public class Ledger {
    static List<String> transHist = new ArrayList<String>();
    static String fileName = "C:\\Users\\Christian\\Documents\\NetBeans 8.2\\Ledger.txt";
    static String line;
    static FileWriter filewriter;
    static BufferedWriter buffer;
    static File file;
    static FileReader filereader;
    static BufferedReader bufferedreader;
    /**
     * This procedure adds transactions to an array list
     */
    public static void addTransHist() {
        if (BabyCrypto.transType.equalsIgnoreCase("buy")) {
            if (WalletBTCXRP.boughtHist != 0) {
               MyDate.currentDate();
               if (BabyCrypto.cryptoType.equalsIgnoreCase("BTC")) {
                   transHist.add("Bought " + WalletBTCXRP.boughtHist + WalletBTCXRP.currency1Ticker + " on " + MyDate.strDate);
               } else if (BabyCrypto.cryptoType.equalsIgnoreCase("XRP")) {
                   transHist.add("Bought " + WalletBTCXRP.boughtHist + WalletBTCXRP.currency3Ticker + " on " + MyDate.strDate);
               }
           }
        } else if (BabyCrypto.transType.equalsIgnoreCase("sell")) {
            if (WalletBTCXRP.soldHist !=0) {
                MyDate.currentDate();
                if (BabyCrypto.cryptoType.equalsIgnoreCase("BTC")) {
                    transHist.add("Sold " + WalletBTCXRP.soldHist + WalletBTCXRP.currency1Ticker + " on " + MyDate.strDate);
                } else if (BabyCrypto.cryptoType.equalsIgnoreCase("XRP")) {
                    transHist.add("Sold " + WalletBTCXRP.soldHist + WalletBTCXRP.currency3Ticker + " on " + MyDate.strDate);
                }
                
            }
        }
        
    }
    /**
     * This procedure saves program inputs to a file
     * @throws Exception 
     */
    public static void saveToFile() throws Exception {
        file = new File(fileName);
        try (PrintWriter output = new PrintWriter(file)) {
            output.print(WalletBTCXRP.currencyUSD + WalletBTCXRP.currency2Ticker);
            output.print(" " + WalletBTCXRP.currencyBTC + WalletBTCXRP.currency1Ticker);
            output.println(" " + WalletBTCXRP.currencyXRP + WalletBTCXRP.currency3Ticker);
            transHist.forEach((transHist1) -> {
                output.println(transHist1);
            });
        }
    }
    /**
     * This procedure loads the file created by saveToFile()
     * @throws Exception 
     */
    public static void loadFile() throws Exception {
        if (file.exists()) {
            // let's print what is in the file
            filereader = new FileReader(fileName);
            bufferedreader = new BufferedReader(filereader);
            while ((line = bufferedreader.readLine()) !=null) {
                JOptionPane.showMessageDialog(null, line, "Here is your Transaction History:", JOptionPane.PLAIN_MESSAGE);
            }   

        }
    }
    
}
