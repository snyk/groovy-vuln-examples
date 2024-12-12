def tainted_url = System.getenv("TAINTED_INPUT")

def safe_url = "https://example.com/${tainted_url}"

// NOT VULNERABLE TO Ssrf HERE
def request = new URL(safe_url).getText()

// deprecated API, but may be present in old code bases
// NOT VULNERABLE TO Ssrf HERE
safe_url.toURL().text
