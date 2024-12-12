import groovy.lang.GroovyShell
import java.net.URLEncoder

def tainted_input = System.getenv("TAINTED_INPUT")

def encoded = URLEncoder.encode(tainted_input)

def sanitized_code = "println('${encoded}')"

def shell = new GroovyShell()
// NOT VULNERABLE TO CodeInjection HERE
def result = shell.evaluate(sanitized_code)


// NOT VULNERABLE TO CodeInjection HERE
def script = shell.parse(sanitized_code)
script.run()