package inti.imgq.verifier

import grails.test.mixin.TestFor
import spock.lang.Specification
import inti.imgq.verifier.ImgVerificator

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ImgVerificator)
class ImgVerificatorSpec extends Specification {

    def static urlBase

    def setup() {
      urlBase = "/home/fbobbio/fingerprint_db/"
    }

    def cleanup() {
    }

    void "La ejecución del algoritmo nfiq para la ruta de imagen #src debe tener un valor de #val"(src,val) {
        given:
          ImgVerificator verificator = new ImgVerificator()
        when:
          verificator.imgSrc = urlBase + src
        then:
          verificator.nfiq() == val
        where:
          src || val
          "reference_images/a001.wsq" || 5
          "reference_images/a002.wsq" || 5
          "reference_images/a018.wsq" || 5
          "reference_images/a039.wsq" || 3
          "reference_images/a070.wsq" || 5
          "reference_images/a076.wsq" || 4
          "reference_images/a089.wsq" || 1
          "reference_images/a107.wsq" || 4
          "sd29/001_01_02.wsq" || 4
          "sd29/001_06_02.wsq" || 2
          "sd29/001_08_02.wsq" || 3
          "sd29/016_07_01.wsq" || 5
          "sd29/022_07_01.wsq" || 3
          "sd29/022_02_01.wsq" || 5
          "sd29/100_03_02.wsq" || 1
          "sd29/101_20_02.wsq" || 1
    }
}
