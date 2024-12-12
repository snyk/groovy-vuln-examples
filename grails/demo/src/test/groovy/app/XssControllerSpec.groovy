package app

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class XssControllerSpec extends Specification implements ControllerUnitTest<XssController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
