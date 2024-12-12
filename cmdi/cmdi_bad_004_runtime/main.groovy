import java.io.IOException;
import java.util.Scanner;

public class CliTest {
    private static class Inner {
        public static Process doCmd(String cmd) throws IOException {
            // IndirectCommandInjection VULNERABILITY HERE
            return java.lang.Runtime.getRuntime().exec(cmd);
        }
    }

    public static void main(String[] args) {
        try {
            Inner.doCmd(args[1]);

            Scanner scanner = new Scanner(System.in);
            String arg = scanner.nextLine();

            Inner.doCmd(arg);
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
}
