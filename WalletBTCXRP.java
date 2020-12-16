package Final;

import javax.swing.JOptionPane;


/**
 * This is a class to update currency values for the program
 * @author Christian Hernandez
 * @version 3.0
 */
public class WalletBTCXRP {
    //How much currency you possess at start

    static double bitcoinInput = 0;
    static double currencyBTC = 0;
    static double currencyXRP = 0;
    static double currencyUSD = 25000;
    static double boughtHist = 0;
    static double soldHist = 0;
    static String currency1Ticker = " BTC";
    static String currency2Ticker = " USD";
    static String currency3Ticker = " XRP";
    
    /**
     * Procedure to buy BitCoins
     */
    static void buyBitcoin() {
        MyJsoup.getBitValue();
        bitcoinInput = BabyCrypto.bitNum;
        currencyBTC += bitcoinInput;
        currencyUSD -= bitcoinInput * MyJsoup.valueBTC;
        if (currencyUSD < 0) {
            currencyUSD += bitcoinInput * MyJsoup.valueBTC;
            currencyBTC -= bitcoinInput;
            boughtHist = 0;
            JOptionPane.showMessageDialog(null, "You don't have enough" + currency2Ticker, "No Money", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Bought " + bitcoinInput + currency1Ticker + "\n" + "Thank You!", "Transaction Complete", JOptionPane.PLAIN_MESSAGE);
            boughtHist = bitcoinInput;
        }
        
    }
    /**
     * Procedure to buy Ripple
     */
    static void buyRipple() {
        MyJsoup.getXRPValue();
        bitcoinInput = BabyCrypto.bitNum;
        currencyXRP += bitcoinInput;
        currencyUSD -= bitcoinInput * MyJsoup.valueXRP;
        if (currencyUSD < 0) {
            currencyUSD += bitcoinInput * MyJsoup.valueXRP;
            currencyXRP -= bitcoinInput;
            boughtHist = 0;
            JOptionPane.showMessageDialog(null, "You don't have enough" + currency2Ticker, "No Money", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Bought " + bitcoinInput + currency3Ticker + "\n" + "Thank You!", "Transaction Complete", JOptionPane.PLAIN_MESSAGE);
            boughtHist = bitcoinInput;
        }
        
    }
    /**
     * Procedure to sell BitCoins
     */
    static void sellBitcoin() {
        MyJsoup.getBitValue();
        bitcoinInput = BabyCrypto.bitNum;
        currencyBTC -= bitcoinInput;
        currencyUSD += bitcoinInput * MyJsoup.valueBTC;
        if (currencyUSD > 20000) {
            currencyBTC += bitcoinInput;
            currencyUSD -= bitcoinInput * MyJsoup.valueBTC;
            JOptionPane.showMessageDialog(null, "You don't have enough" + currency1Ticker, "No Money", JOptionPane.PLAIN_MESSAGE);
            soldHist = 0;
        } else {
            JOptionPane.showMessageDialog(null, "Sold " + bitcoinInput + currency1Ticker + "\n" + "Thank You!", "Transaction Complete", JOptionPane.PLAIN_MESSAGE);
            soldHist = bitcoinInput;
        }
        
    }
    /**
     * Procedure to sell Ripple
     */
    static void sellRipple() {
        MyJsoup.getXRPValue();
        bitcoinInput = BabyCrypto.bitNum;
        currencyXRP -= bitcoinInput;
        currencyUSD += bitcoinInput * MyJsoup.valueXRP;
        if (currencyUSD > 20000) {
            currencyXRP += bitcoinInput;
            currencyUSD -= bitcoinInput * MyJsoup.valueXRP;
            JOptionPane.showMessageDialog(null, "You don't have enough" + currency3Ticker, "No Money", JOptionPane.PLAIN_MESSAGE);
            soldHist = 0;
        } else {
            JOptionPane.showMessageDialog(null, "Sold " + bitcoinInput + currency3Ticker + "\n" + "Thank You!", "Transaction Complete", JOptionPane.PLAIN_MESSAGE);
            soldHist = bitcoinInput;
        }
        
    }
    
    public static void main(String[] args) {
        //Displays Balance
        JOptionPane.showMessageDialog(null, "You have " + currencyBTC + " " + currency1Ticker + 
                "\n" + "You have " + currencyXRP + " " + currency3Ticker + "\n" + "You have " + currencyUSD + " " + currency2Ticker, "Here is your Balance:" , JOptionPane.PLAIN_MESSAGE);
        /*System.out.println("You have " + currencyBTC + " " + currency1Ticker);
        System.out.println("You have " + currencyXRP + " " + currency3Ticker);
        System.out.println("You have " + currencyUSD + " " + currency2Ticker);*/
    }
    
}
