// HardcodedPassword VULNERABILITY HERE
def password = "supersecret"

// NoHardcodedCredentials VULNERABILITY HERE
def user = "root"

// NonCryptoHardcodedSecret VULNERABILITY HERE
def JWT_SECRET1 = "UHgI9BgC5gFsxSlh2SRfZppQEQnaetQ1Ts42c4r6O68"


println("${user} ${password} ${JWT_SECRET1}")