import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public final class PT_BufferedReader {
  public static void main() {
    try {
        def tainted_input = new URL("https://example.com").getText();
        def tmp = Files.createTempFile(tainted_input, ".tmp");
        def writer = new BufferedWriter(new FileWriter(tmp.toFile())); // NOT VULNERABLE TO PT HERE
        writer.close();
    } catch (IOException e) {}
  }

}
