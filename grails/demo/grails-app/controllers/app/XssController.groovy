package app

import groovy.json.JsonBuilder

class XssController {
    // localhost:8080/xss?name=<img src=1 href=1 onerror="javascript:alert(1)"></img>
    def index() {
        render "Hello ${params.name}!"
    }

    def bad_02() {
        render(text: "Hello ${params.name}!")
    }

    def bad_03() {
        render(text: "Hello ${params.name}!", contentType: "text/html")
    }

        // http://localhost:8080/xss/bad_04?name=<img src=1 href=1 onerror='javascript:alert(1)'></img>
    def bad_04() {
        render new JsonBuilder([params.name]).toString()
    }
}