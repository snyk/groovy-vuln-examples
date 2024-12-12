package app

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class XssControllerControllerSpec extends Specification implements ControllerUnitTest<XssControllerController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
