import java.io.File;
import groovy.io.FileType

def tainted_input = new URL("https://example.com").getText()
def folder = new File(tainted_input);

if (!folder.getCanonicalPath().startsWith("/tmp/")) {
    throw new Exception("Forbidden file access");
}

folder.eachFile({ f -> 
    // NOT VULNERABLE TO PT HERE
    f.append('hello');
})
