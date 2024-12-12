package app

import groovy.xml.MarkupBuilder

import grails.converters.XML

class XssGoodController {
    // localhost:8080/xssGood?name=<img src=1 href=1 onerror="javascript:alert(1)"></img>
    def index() {
        // dc!expect XSS
        render(
            [name: params.name, msg: "Hello"] as grails.converters.JSON,
            contentType: "application/json"
        )
    }

    def good_02() {
        // dc!expect XSS
        render([name: params.name, msg: "Hello"] as grails.converters.JSON)
    }

    def good_03() {

        // dc!expect XSS
        render {
            div(id: "myDiv", "Hello ${params.name}")
        }
    }

    def good_04() {
        def writer = new StringWriter()
        def builder = new MarkupBuilder(writer)

        builder.html {
            div(id: "myDiv", "Hello ${params.name}")
        }

        def html = writer.toString()

        // dc!expect XSS
        render html
    }

    def good_05() {
        grails.converters.JSON result = inputAsJson(params.name)

        // dc!expect XSS
        render result
    }

    private grails.converters.JSON inputAsJson(String username) {
        grails.converters.JSON result = [
            name: username, msg: "Hello"
        ] as grails.converters.JSON

        return result
    }

    def good_06() {
        def result = inputAsXml(params.name)

        // dc!expect XSS
        render result
    }

    private XML inputAsXml(String username) {
        def result = [
            name: username, msg: "Hello"
        ] as XML

        return result
    }

    def good_07() {
        // dc!expect XSS
        render(view: params.name)
    }
}
