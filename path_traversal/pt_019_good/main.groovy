import java.io.File;
import groovy.json.JsonSlurper;

def tainted_path = System.getenv("TAINTED_INPUT");
def f = new File(tainted_path);

// createTempDir is not being treated as a sink
// NOT VULNERABLE TO PT HERE
f.createTempDir();

if (!f.getCanonicalPath().startsWith("/tmp/")) {
    throw new Exception("Forbidden file access");
}

// NOT VULNERABLE TO PT HERE
f.append('hello');

// NOT VULNERABLE TO PT HERE
new JsonSlurper().parse(f);
