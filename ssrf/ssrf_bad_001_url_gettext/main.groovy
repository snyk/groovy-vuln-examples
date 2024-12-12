def tainted_url = System.getenv("TAINTED_INPUT")

// Ssrf VULNERABILITY HERE
def request = new URL(tainted_url).getText()

// deprecated API, but may be present in old code bases
// Ssrf VULNERABILITY HERE
tainted_url.toURL().text
