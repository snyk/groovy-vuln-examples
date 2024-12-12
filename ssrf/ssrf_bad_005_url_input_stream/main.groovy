
def tainted_url = System.getenv("TAINTED_INPUT")

// Ssrf VULNERABILITY HERE
def stream = new URL(tainted_url).newInputStream()

stream.eachLine {
    println it
}