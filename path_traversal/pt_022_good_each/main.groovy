import java.io.File;
import groovy.io.FileType

def tainted_input = new URL("https://example.com").getText()
def folder = new File(tainted_input);

folder.eachFile({ f -> 
    if (!f.getCanonicalPath().startsWith("/tmp/")) {
        throw new Exception("Forbidden file access");
    }
    // NOT VULNERABLE TO PT HERE
    f.append('hello');
})
