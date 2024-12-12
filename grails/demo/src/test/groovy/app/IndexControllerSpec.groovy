package app

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class IndexControllerSpec extends Specification implements ControllerUnitTest<IndexController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
