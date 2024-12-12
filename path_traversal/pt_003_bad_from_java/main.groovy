

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;

public final class PT_DataOutputStream {
  public static void vuln() {
    def tainted_input = new URL("https://example.com").getText();
    def file = new File(tainted_input);
    def os;
    try {
        // FileOutputStream is vuln to PT, as the path can be controlled, not necessarily DataOutputStream
        os = new DataOutputStream(new FileOutputStream(file)); // PT VULNERABILITY HERE
    } catch (IOException e) {} finally {
        os.close();
    }
  }
}
