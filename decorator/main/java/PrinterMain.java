public class PrinterMain {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("Hello sir! How has your day been?");

        System.out.println("\n--- Using Encrypted and File Printer ---\n");

        Printer printer2 = new EncryptedPrinter(new FilePrinter(new BasicPrinter()));
        printer2.print("You have successfully decrypted this message. I salute you.");
    }
}
