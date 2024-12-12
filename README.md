# groovy-vuln-examples

This repo contains examples of some common Groovy related security vulnerabilities. These currently include:

*  Hardcoded Secret: Storing sensitive information such as API keys, passwords, or tokens directly in the source code, which can be exposed if the code is shared or compromised.

*  SQL Injection (SQLi): A vulnerability that allows an attacker to manipulate SQL queries by injecting malicious input, leading to unauthorized access, data leaks, or even database compromise.

*  Server-Side Request Forgery (SSRF): An attacker tricks the server into making requests to internal or external resources that the attacker wouldn’t normally have access to, which could lead to information disclosure or further attacks.

* Command Injection: An attacker injects malicious commands into a program's input, allowing them to execute arbitrary code on the system.

* Code Injection: Similar to command injection, but the attacker injects malicious code into a program's execution context, often through a dynamic language or insecure deserialization.

* Deserialization of Untrusted Data: A vulnerability where an attacker can exploit the deserialization process to inject malicious code or objects into a system.

* Hardcoded Password: A security risk where passwords are directly embedded within the code, making them vulnerable to exposure.

* Path Traversal: An attacker manipulates file paths to access or modify files outside the intended directory, potentially leading to unauthorized file access or system compromise.

* XXE (XML External Entity): An attack where an attacker exploits XML processing features to access sensitive information or execute malicious code.

* Open Redirect - An open redirect occurs when a web application accepts untrusted user input and uses it to construct a URL for redirection without proper validation. This can allow an attacker to redirect users to malicious websites.

* XSS - Cross-Site Scripting occurs when an attacker injects malicious scripts into web pages that are then executed by other users' browsers. This can lead to data theft, session hijacking, or defacement.
