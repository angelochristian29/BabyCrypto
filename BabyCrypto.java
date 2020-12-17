package Final;


import javax.swing.JOptionPane;

/**
 * This is the main menu program for the user to interact with
 * @author Christian Hernandez
 * @version 3.0
 */
public class BabyCrypto {
    // switch
    static String bitCommand;
    static String bitCommandSplit [];
    static String transType;
    static String cryptoType;
    static double bitNum;

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        JOptionPane.showMessageDialog(null, "Select an option by inputing strings on the keyboard: " + 
                "\n" + "For Value of BitCoin type: price " + 
                "\n" + "To Buy Bitcoins type: buy <num> <coin>" + 
                "\n" + "To Sell Bitcoins type: sell <num> <coin>" + 
                "\n" + "To Print your Wallet type: wallet" + 
                "\n" + "To save history type: save ledger" +
                "\n" + "For History type: load ledger" + "\n" + 
                "\n" + "To stop program type: quit" + 
                "\n" + "You have " + WalletBTCXRP.currencyUSD + WalletBTCXRP.currency2Ticker + " to spend on Bitcoin" + 
                "\n" + "", "BabyCrypto Menu", JOptionPane.PLAIN_MESSAGE);
        
        //System.out.print();
        bitCommand = JOptionPane.showInputDialog("Select Option Here:");
        
        while (!(bitCommand.equalsIgnoreCase("quit"))) {
            if (!(bitCommand.equalsIgnoreCase("quit") || bitCommand.equalsIgnoreCase("price"))) {
                if (!(bitCommand.equalsIgnoreCase("wallet") || bitCommand.equalsIgnoreCase("load ledger"))) {
                    if (!(bitCommand.equalsIgnoreCase("save ledger"))) {
                        bitCommandSplit = bitCommand.split(" ");
                        transType = bitCommandSplit[0];
                        cryptoType = bitCommandSplit[2];
                        bitNum = Double.parseDouble(bitCommandSplit[1]);
                        if (transType.equalsIgnoreCase("buy")) {
                            if (cryptoType.equalsIgnoreCase("BTC")) {
                                WalletBTCXRP.buyBitcoin();
                                Ledger.addTransHist();
                            } else if (cryptoType.equalsIgnoreCase("XRP")) {
                                WalletBTCXRP.buyRipple();
                                Ledger.addTransHist();
                            }
                        } else if (transType.equalsIgnoreCase("sell")) {
                            if (cryptoType.equalsIgnoreCase("BTC")) {
                                WalletBTCXRP.sellBitcoin();
                                Ledger.addTransHist();
                            } else if (cryptoType.equalsIgnoreCase("XRP")) {
                                WalletBTCXRP.sellRipple();
                                Ledger.addTransHist();
                            }
                        }
                    }
                }
            }
            
            switch (bitCommand) {
                case "price":
                    MyJsoup.getBitValue();
                    MyJsoup.getXRPValue();
                    JOptionPane.showMessageDialog(null, "The current value of 1 Bitcoin is " + MyJsoup.valueBTC + WalletBTCXRP.currency2Ticker + "\n" + "" + 
                            "\n" + "The current value of 1 Ripple is " + MyJsoup.valueXRP + WalletBTCXRP.currency2Ticker + "\n" + "", "Crypto Price", JOptionPane.PLAIN_MESSAGE);
                    break;
                case "wallet":
                    WalletBTCXRP.main(args);
                    break;
                case "load ledger":
                    Ledger.loadFile();
                    break;
                case "save ledger":
                    Ledger.saveToFile();
                    JOptionPane.showMessageDialog(null, "Ledger Saved!", "", JOptionPane.PLAIN_MESSAGE);
                    break;
                case "quit":
                    break;
                default:
                    break;
            }
            bitCommand = JOptionPane.showInputDialog("Select Option Here:");
        }
        //System.out.println("");
        JOptionPane.showMessageDialog(null, "Have a Cryptacular day!", "Program End", JOptionPane.PLAIN_MESSAGE);
    }
}
