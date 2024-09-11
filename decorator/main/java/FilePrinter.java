import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter extends PrinterDecorator {
    private String fileName = "output.txt";

    public FilePrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        super.print(message);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(message);
            writer.newLine();
            System.out.println("A message has been written to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
