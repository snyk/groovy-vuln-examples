
def tainted_url = System.getenv("TAINTED_INPUT")

def url = new URL(tainted_url)

// Ssrf VULNERABILITY HERE
def connection = url.openConnection() as HttpURLConnection
connection.requestMethod = 'GET'

if (connection.responseCode == 200) {
    def response = connection.inputStream.text
    println "Response: ${response.take(100)}"
} else {
    println "Failed to fetch the URL. Response code: ${connection.responseCode}"
}

connection.disconnect()