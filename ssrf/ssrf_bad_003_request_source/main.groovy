// Response http client request should be treated as tainted
def tainted_address = new URL("https://example.com").getText()

// Ssrf VULNERABILITY HERE
def response_from_address = new URL(tainted_address).getText()

// Ssrf VULNERABILITY HERE
def response_from_address2 = response_from_address.toURL().text;