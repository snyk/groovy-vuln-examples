import groovy.lang.GroovyShell

def tainted_code = System.getenv("TAINTED_INPUT")

def shell = new GroovyShell()
// CodeInjection VULNERABILITY HERE
def result = shell.evaluate(tainted_code)


// CodeInjection VULNERABILITY HERE
def script = shell.parse(tainted_code)
script.run()
