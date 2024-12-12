import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public final class PT_BufferedReader {
  public static void main() {
    def tainted_path = System.getenv("TAINTED_INPUT");
    def file = new File(tainted_path);
    
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // PT VULNERABILITY HERE
      writer.close();
    } catch (IOException e) {}
  }
}
