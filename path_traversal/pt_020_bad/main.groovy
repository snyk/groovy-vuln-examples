import java.io.File;

def tainted_input = new URL("https://example.com").getText()
def f = new File(tainted_input);

// PT VULNERABILITY HERE
f.append('hello');
