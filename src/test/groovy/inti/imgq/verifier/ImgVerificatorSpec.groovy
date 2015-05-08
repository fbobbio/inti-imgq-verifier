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
          verificator.imgSrc = urlBase + "reference_images/" + src
          verificator.nfiq()
        then:
          verificator.nfiqValue == val
        where:
          src || val
          "a001.wsq" || 5
          "a002.wsq" || 5
          "a018.wsq" || 5
          "a039.wsq" || 3
          "a070.wsq" || 5
          "a076.wsq" || 4
          "a089.wsq" || 1
          "a107.wsq" || 4
    }

    void "Ejecución del NFIQ_COMPLIANCE_TEST para calibrado de entorno"() {
        given:
          ImgVerificator verificator = new ImgVerificator()
        when:
          verificator.imgSrc = urlBase + "sd29/" + src
          verificator.nfiq()
        then:
          verificator.nfiqValue == val
      where:
        src || val
        "001_01_02.wsq" || 4
        "001_06_02.wsq" || 2
        "001_08_02.wsq" || 3
        "001_12_01.wsq" || 3
        "001_15_02.wsq" || 2
        "001_19_02.wsq" || 2
        "001_20_01.wsq" || 3
        "002_15_01.wsq" || 2
        "002_20_02.wsq" || 2
        "004_01_02.wsq" || 3
        "004_06_02.wsq" || 2
        "004_07_01.wsq" || 3
        "004_11_01.wsq" || 3
        "004_16_01.wsq" || 3
        "004_19_01.wsq" || 2
        "004_20_01.wsq" || 3
        "006_03_01.wsq" || 4
        "006_07_01.wsq" || 4
        "006_12_01.wsq" || 3
        "006_12_02.wsq" || 3
        "006_19_01.wsq" || 2
        "006_19_02.wsq" || 3
        "006_20_01.wsq" || 3
        "007_01_01.wsq" || 4
        "007_03_02.wsq" || 2
        "007_07_02.wsq" || 2
        "007_08_01.wsq" || 2
        "007_08_02.wsq" || 2
        "007_12_02.wsq" || 2
        "007_15_02.wsq" || 2
        "007_16_01.wsq" || 3
        "007_16_02.wsq" || 2
        "007_20_01.wsq" || 3
        "007_20_02.wsq" || 3
        "008_02_02.wsq" || 2
        "008_03_01.wsq" || 3
        "008_06_02.wsq" || 2
        "008_08_02.wsq" || 2
        "008_11_02.wsq" || 3
        "008_15_02.wsq" || 2
        "008_16_01.wsq" || 3
        "008_16_02.wsq" || 3
        "008_20_02.wsq" || 3
        "009_01_01.wsq" || 2
        "009_02_01.wsq" || 3
        "009_02_02.wsq" || 3
        "009_03_02.wsq" || 3
        "009_06_01.wsq" || 2
        "009_06_02.wsq" || 2
        "009_07_01.wsq" || 3
        "009_07_02.wsq" || 3
        "009_08_01.wsq" || 2
        "009_11_01.wsq" || 3
        "009_11_02.wsq" || 3
        "009_12_01.wsq" || 3
        "009_12_02.wsq" || 2
        "009_15_01.wsq" || 3
        "009_16_01.wsq" || 2
        "009_19_01.wsq" || 3
        "009_19_02.wsq" || 3
        "009_20_01.wsq" || 3
        "010_01_01.wsq" || 2
        "010_07_02.wsq" || 4
        "010_08_01.wsq" || 3
        "010_15_02.wsq" || 3
        "010_16_01.wsq" || 3
        "010_20_02.wsq" || 2
        "011_06_01.wsq" || 2
        "011_12_02.wsq" || 2
        "011_15_02.wsq" || 2
        "011_19_02.wsq" || 2
        "015_02_01.wsq" || 2
        "015_03_01.wsq" || 2
        "015_07_01.wsq" || 2
        "015_11_01.wsq" || 2
        "015_15_01.wsq" || 2
        "015_15_02.wsq" || 2
        "015_16_02.wsq" || 2
        "015_20_01.wsq" || 2
        "015_20_02.wsq" || 2
        "016_01_01.wsq" || 2
        "016_01_02.wsq" || 2
        "016_02_02.wsq" || 2
        "016_06_01.wsq" || 2
        "016_07_01.wsq" || 5
        "016_07_02.wsq" || 2
        "016_12_02.wsq" || 3
        "016_15_02.wsq" || 2
        "016_16_02.wsq" || 3
        "016_19_02.wsq" || 2
        "016_20_02.wsq" || 3
        "017_03_02.wsq" || 3
        "017_08_01.wsq" || 2
        "017_11_02.wsq" || 3
        "017_15_02.wsq" || 2
        "017_16_01.wsq" || 2
        "017_16_02.wsq" || 2
        "017_19_02.wsq" || 2
        "017_20_02.wsq" || 2
        "018_02_02.wsq" || 3
        "018_07_01.wsq" || 3
        "018_07_02.wsq" || 3
        "018_08_01.wsq" || 3
        "018_08_02.wsq" || 3
        "018_11_01.wsq" || 4
        "018_15_01.wsq" || 3
        "018_16_01.wsq" || 2
        "018_16_02.wsq" || 2
        "018_19_01.wsq" || 2
        "018_19_02.wsq" || 2
        "018_20_01.wsq" || 2
        "018_20_02.wsq" || 2
        "019_02_01.wsq" || 3
        "019_02_02.wsq" || 3
        "019_03_01.wsq" || 3
        "019_03_02.wsq" || 3
        "019_07_01.wsq" || 3
        "019_07_02.wsq" || 3
        "019_08_02.wsq" || 3
        "019_12_01.wsq" || 3
        "019_12_02.wsq" || 3
        "019_15_01.wsq" || 3
        "019_16_01.wsq" || 4
        "019_19_01.wsq" || 2
        "019_19_02.wsq" || 3
        "019_20_02.wsq" || 2
        "020_02_01.wsq" || 3
        "020_02_02.wsq" || 3
        "020_03_02.wsq" || 3
        "020_07_02.wsq" || 3
        "020_08_02.wsq" || 3
        "020_11_01.wsq" || 3
        "020_11_02.wsq" || 3
        "020_15_01.wsq" || 2
        "020_15_02.wsq" || 2
        "020_16_02.wsq" || 2
        "020_19_01.wsq" || 2
        "020_19_02.wsq" || 3
        "020_20_01.wsq" || 2
        "021_02_01.wsq" || 3
        "021_02_02.wsq" || 3
        "021_03_01.wsq" || 3
        "021_06_01.wsq" || 3
        "021_07_02.wsq" || 4
        "021_08_01.wsq" || 3
        "021_08_02.wsq" || 3
        "021_11_01.wsq" || 3
        "021_11_02.wsq" || 3
        "021_12_01.wsq" || 4
        "021_12_02.wsq" || 4
        "021_16_01.wsq" || 5
        "021_16_02.wsq" || 3
        "021_20_01.wsq" || 3
        "021_20_02.wsq" || 2
        "022_02_01.wsq" || 5
        "022_07_01.wsq" || 3
        "022_08_02.wsq" || 3
        "022_15_01.wsq" || 3
        "022_15_02.wsq" || 4
        "022_16_01.wsq" || 4
        "022_16_02.wsq" || 3
        "022_19_01.wsq" || 4
        "022_19_02.wsq" || 3
        "026_01_02.wsq" || 3
        "026_11_02.wsq" || 2
        "026_12_01.wsq" || 3
        "026_12_02.wsq" || 2
        "026_15_02.wsq" || 2
        "026_19_01.wsq" || 2
        "026_20_01.wsq" || 2
        "028_01_02.wsq" || 2
        "028_03_02.wsq" || 3
        "028_07_02.wsq" || 3
        "028_08_02.wsq" || 3
        "028_11_01.wsq" || 3
        "028_11_02.wsq" || 2
        "028_12_01.wsq" || 3
        "028_15_01.wsq" || 4
        "028_15_02.wsq" || 3
        "028_16_01.wsq" || 2
        "028_19_01.wsq" || 3
        "029_02_01.wsq" || 3
        "029_03_01.wsq" || 3
        "029_03_02.wsq" || 3
        "029_07_01.wsq" || 3
        "029_08_01.wsq" || 3
        "029_11_01.wsq" || 3
        "029_12_02.wsq" || 3
        "029_15_01.wsq" || 3
        "029_15_02.wsq" || 3
        "029_19_01.wsq" || 3
        "029_19_02.wsq" || 2
        "029_20_01.wsq" || 3
        "030_02_01.wsq" || 3
        "030_02_02.wsq" || 3
        "030_07_01.wsq" || 3
        "030_08_01.wsq" || 3
        "030_11_02.wsq" || 2
        "030_12_01.wsq" || 3
        "030_15_02.wsq" || 2
        "030_19_01.wsq" || 3
        "030_19_02.wsq" || 2
        "030_20_02.wsq" || 2
        "031_02_01.wsq" || 2
        "031_03_01.wsq" || 2
        "031_06_01.wsq" || 2
        "031_06_02.wsq" || 2
        "031_12_01.wsq" || 3
        "031_15_01.wsq" || 2
        "033_03_02.wsq" || 3
        "033_06_01.wsq" || 2
        "033_11_01.wsq" || 3
        "033_12_01.wsq" || 3
        "033_15_01.wsq" || 2
        "033_16_02.wsq" || 2
        "033_19_01.wsq" || 3
        "033_20_01.wsq" || 2
        "033_20_02.wsq" || 2
        "034_03_02.wsq" || 3
        "034_06_01.wsq" || 3
        "034_06_02.wsq" || 3
        "034_11_02.wsq" || 3
        "034_12_01.wsq" || 3
        "034_15_01.wsq" || 3
        "034_15_02.wsq" || 3
        "034_16_01.wsq" || 2
        "034_16_02.wsq" || 2
        "034_19_02.wsq" || 3
        "034_20_01.wsq" || 2
        "034_20_02.wsq" || 2
        "038_07_01.wsq" || 3
        "038_08_01.wsq" || 3
        "038_15_02.wsq" || 2
        "038_16_02.wsq" || 2
        "038_19_02.wsq" || 2
        "038_20_02.wsq" || 3
        "039_02_01.wsq" || 3
        "039_02_02.wsq" || 3
        "039_03_01.wsq" || 3
        "039_03_02.wsq" || 3
        "039_06_02.wsq" || 3
        "039_07_01.wsq" || 3
        "039_07_02.wsq" || 3
        "039_08_01.wsq" || 3
        "039_08_02.wsq" || 3
        "039_11_01.wsq" || 2
        "039_11_02.wsq" || 2
        "039_15_01.wsq" || 3
        "039_16_02.wsq" || 3
        "039_19_01.wsq" || 3
        "039_19_02.wsq" || 2
        "040_03_02.wsq" || 3
        "040_08_01.wsq" || 3
        "040_08_02.wsq" || 3
        "040_11_01.wsq" || 2
        "040_11_02.wsq" || 2
        "040_12_02.wsq" || 3
        "040_15_02.wsq" || 3
        "040_19_02.wsq" || 2
        "040_20_01.wsq" || 3
        "041_02_01.wsq" || 3
        "041_02_02.wsq" || 2
        "041_03_01.wsq" || 3
        "041_07_01.wsq" || 3
        "041_08_01.wsq" || 3
        "041_11_02.wsq" || 3
        "041_12_02.wsq" || 3
        "041_15_01.wsq" || 3
        "041_15_02.wsq" || 2
        "041_19_01.wsq" || 2
        "041_19_02.wsq" || 3
        "044_02_01.wsq" || 3
        "044_02_02.wsq" || 3
        "044_07_02.wsq" || 3
        "044_08_01.wsq" || 3
        "044_19_01.wsq" || 2
        "044_19_02.wsq" || 2
        "044_20_01.wsq" || 3
        "044_20_02.wsq" || 2
        "045_02_02.wsq" || 3
        "045_03_02.wsq" || 4
        "045_07_01.wsq" || 3
        "045_08_02.wsq" || 3
        "045_15_02.wsq" || 3
        "045_16_02.wsq" || 3
        "046_02_02.wsq" || 3
        "046_11_01.wsq" || 2
        "046_12_02.wsq" || 4
        "046_15_01.wsq" || 3
        "046_16_01.wsq" || 2
        "046_16_02.wsq" || 2
        "046_20_02.wsq" || 2
        "048_01_02.wsq" || 3
        "048_11_01.wsq" || 3
        "048_12_01.wsq" || 3
        "048_12_02.wsq" || 4
        "048_16_02.wsq" || 3
        "048_19_02.wsq" || 3
        "048_20_02.wsq" || 2
        "049_02_01.wsq" || 3
        "049_03_01.wsq" || 3
        "049_15_02.wsq" || 4
        "049_16_02.wsq" || 2
        "049_19_02.wsq" || 2
        "049_20_01.wsq" || 2
        "049_20_02.wsq" || 2
        "050_01_02.wsq" || 2
        "050_03_01.wsq" || 3
        "050_03_02.wsq" || 4
        "050_06_02.wsq" || 2
        "050_11_01.wsq" || 3
        "050_12_01.wsq" || 5
        "050_15_01.wsq" || 3
        "050_15_02.wsq" || 3
        "050_16_01.wsq" || 3
        "050_16_02.wsq" || 2
        "050_20_01.wsq" || 2
        "050_20_02.wsq" || 2
        "051_01_01.wsq" || 3
        "051_01_02.wsq" || 2
        "051_03_02.wsq" || 2
        "051_07_01.wsq" || 3
        "051_07_02.wsq" || 5
        "051_20_01.wsq" || 3
        "051_20_02.wsq" || 4
        "052_01_02.wsq" || 2
        "052_02_01.wsq" || 4
        "052_03_01.wsq" || 3
        "052_07_01.wsq" || 3
        "052_11_01.wsq" || 3
        "052_11_02.wsq" || 3
        "052_12_02.wsq" || 2
        "052_15_01.wsq" || 3
        "052_15_02.wsq" || 3
        "052_16_01.wsq" || 3
        "052_19_01.wsq" || 3
        "052_19_02.wsq" || 3
        "053_03_02.wsq" || 2
        "053_07_02.wsq" || 2
        "053_08_02.wsq" || 2
        "053_15_01.wsq" || 2
        "053_19_01.wsq" || 2
        "054_03_01.wsq" || 2
        "054_12_01.wsq" || 2
        "054_12_02.wsq" || 3
        "054_15_01.wsq" || 2
        "054_16_01.wsq" || 2
        "054_16_02.wsq" || 2
        "054_19_01.wsq" || 2
        "054_19_02.wsq" || 2
        "054_20_01.wsq" || 2
        "054_20_02.wsq" || 3
        "055_06_01.wsq" || 2
        "055_08_02.wsq" || 2
        "055_11_02.wsq" || 3
        "055_12_02.wsq" || 3
        "055_15_02.wsq" || 4
        "055_16_01.wsq" || 2
        "055_16_02.wsq" || 2
        "055_20_01.wsq" || 2
        "055_20_02.wsq" || 2
        "056_03_01.wsq" || 3
        "056_16_01.wsq" || 2
        "056_19_02.wsq" || 4
        "057_07_01.wsq" || 4
        "057_07_02.wsq" || 4
        "057_15_01.wsq" || 2
        "057_15_02.wsq" || 2
        "057_19_01.wsq" || 2
        "057_20_01.wsq" || 2
        "057_20_02.wsq" || 2
        "058_01_01.wsq" || 2
        "058_01_02.wsq" || 2
        "058_02_01.wsq" || 3
        "058_06_01.wsq" || 3
        "058_07_01.wsq" || 3
        "058_08_01.wsq" || 3
        "058_12_02.wsq" || 3
        "058_15_02.wsq" || 5
        "058_16_01.wsq" || 2
        "058_16_02.wsq" || 2
        "058_19_02.wsq" || 3
        "058_20_01.wsq" || 2
        "058_20_02.wsq" || 2
        "060_02_01.wsq" || 3
        "060_02_02.wsq" || 2
        "060_03_01.wsq" || 3
        "060_07_02.wsq" || 2
        "060_11_02.wsq" || 3
        "060_15_01.wsq" || 2
        "060_15_02.wsq" || 2
        "060_16_01.wsq" || 3
        "060_16_02.wsq" || 3
        "060_19_01.wsq" || 2
        "060_19_02.wsq" || 3
        "061_20_01.wsq" || 2
        "061_20_02.wsq" || 2
        "063_01_02.wsq" || 2
        "063_02_01.wsq" || 3
        "063_02_02.wsq" || 3
        "063_03_01.wsq" || 3
        "063_08_01.wsq" || 3
        "063_11_01.wsq" || 2
        "063_11_02.wsq" || 3
        "063_12_01.wsq" || 2
        "063_12_02.wsq" || 3
        "063_15_02.wsq" || 3
        "063_19_02.wsq" || 2
        "064_16_01.wsq" || 2
        "064_16_02.wsq" || 2
        "064_19_02.wsq" || 2
        "064_20_01.wsq" || 2
        "065_07_02.wsq" || 4
        "065_15_01.wsq" || 2
        "065_15_02.wsq" || 3
        "066_03_01.wsq" || 3
        "066_03_02.wsq" || 2
        "066_15_01.wsq" || 5
        "066_20_01.wsq" || 2
        "067_01_01.wsq" || 3
        "067_01_02.wsq" || 4
        "067_11_02.wsq" || 3
        "067_15_02.wsq" || 3
        "067_16_02.wsq" || 2
        "067_19_02.wsq" || 5
        "068_08_02.wsq" || 3
        "068_15_01.wsq" || 3
        "068_16_01.wsq" || 3
        "070_03_01.wsq" || 2
        "070_08_02.wsq" || 3
        "070_12_01.wsq" || 3
        "070_19_01.wsq" || 2
        "070_19_02.wsq" || 2
        "070_20_01.wsq" || 2
        "070_20_02.wsq" || 2
        "071_06_01.wsq" || 3
        "071_12_01.wsq" || 2
        "071_12_02.wsq" || 3
        "071_15_01.wsq" || 3
        "071_16_02.wsq" || 3
        "071_19_01.wsq" || 2
        "071_19_02.wsq" || 2
        "072_02_01.wsq" || 2
        "072_02_02.wsq" || 2
        "072_03_01.wsq" || 2
        "072_03_02.wsq" || 2
        "072_07_01.wsq" || 2
        "072_07_02.wsq" || 2
        "072_12_01.wsq" || 3
        "072_12_02.wsq" || 3
        "072_15_01.wsq" || 2
        "072_16_02.wsq" || 3
        "072_19_01.wsq" || 2
        "072_19_02.wsq" || 3
        "072_20_01.wsq" || 4
        "073_01_02.wsq" || 3
        "073_03_01.wsq" || 2
        "073_07_01.wsq" || 2
        "073_11_01.wsq" || 3
        "073_11_02.wsq" || 3
        "073_12_01.wsq" || 3
        "073_12_02.wsq" || 3
        "073_15_02.wsq" || 2
        "073_16_01.wsq" || 2
        "073_19_01.wsq" || 2
        "073_20_01.wsq" || 2
        "074_02_01.wsq" || 2
        "074_03_02.wsq" || 3
        "074_06_01.wsq" || 2
        "074_07_02.wsq" || 3
        "074_08_02.wsq" || 3
        "074_11_01.wsq" || 3
        "074_11_02.wsq" || 3
        "074_12_01.wsq" || 3
        "074_15_02.wsq" || 2
        "074_16_01.wsq" || 3
        "074_16_02.wsq" || 3
        "074_19_01.wsq" || 2
        "074_20_01.wsq" || 3
        "074_20_02.wsq" || 3
        "075_01_01.wsq" || 3
        "075_02_01.wsq" || 3
        "075_02_02.wsq" || 3
        "075_03_01.wsq" || 3
        "075_06_01.wsq" || 3
        "075_06_02.wsq" || 5
        "075_11_01.wsq" || 2
        "075_12_02.wsq" || 2
        "075_15_02.wsq" || 3
        "075_16_01.wsq" || 3
        "075_16_02.wsq" || 2
        "075_19_02.wsq" || 3
        "075_20_01.wsq" || 2
        "076_01_02.wsq" || 4
        "076_02_01.wsq" || 3
        "076_12_01.wsq" || 4
        "076_12_02.wsq" || 3
        "076_15_01.wsq" || 2
        "076_15_02.wsq" || 2
        "076_20_02.wsq" || 3
        "077_01_02.wsq" || 2
        "077_03_01.wsq" || 3
        "077_03_02.wsq" || 2
        "077_06_02.wsq" || 2
        "077_07_02.wsq" || 2
        "077_16_02.wsq" || 2
        "077_19_02.wsq" || 2
        "078_01_01.wsq" || 2
        "078_01_02.wsq" || 3
        "078_02_01.wsq" || 3
        "078_03_01.wsq" || 3
        "078_07_02.wsq" || 5
        "078_08_01.wsq" || 4
        "078_12_01.wsq" || 4
        "078_15_01.wsq" || 3
        "078_15_02.wsq" || 3
        "078_19_01.wsq" || 4
        "078_20_01.wsq" || 5
        "078_20_02.wsq" || 3
        "079_01_01.wsq" || 2
        "079_11_02.wsq" || 2
        "079_15_01.wsq" || 2
        "079_15_02.wsq" || 2
        "079_19_01.wsq" || 3
        "080_02_01.wsq" || 3
        "080_03_01.wsq" || 3
        "080_07_01.wsq" || 3
        "080_08_01.wsq" || 3
        "080_12_01.wsq" || 3
        "080_15_01.wsq" || 3
        "080_15_02.wsq" || 3
        "080_20_01.wsq" || 2
        "081_01_02.wsq" || 2
        "081_07_01.wsq" || 3
        "081_11_01.wsq" || 3
        "081_11_02.wsq" || 2
        "081_12_01.wsq" || 3
        "081_12_02.wsq" || 4
        "081_19_01.wsq" || 3
        "081_20_02.wsq" || 2
        "082_02_01.wsq" || 5
        "082_02_02.wsq" || 5
        "082_07_01.wsq" || 3
        "082_08_01.wsq" || 3
        "082_11_02.wsq" || 3
        "082_12_02.wsq" || 3
        "082_15_02.wsq" || 4
        "082_16_01.wsq" || 3
        "082_16_02.wsq" || 3
        "082_19_01.wsq" || 4
        "082_19_02.wsq" || 3
        "082_20_01.wsq" || 3
        "082_20_02.wsq" || 3
        "083_08_01.wsq" || 3
        "083_19_01.wsq" || 2
        "083_19_02.wsq" || 2
        "084_07_01.wsq" || 2
        "084_08_01.wsq" || 2
        "084_12_02.wsq" || 2
        "085_08_01.wsq" || 2
        "085_12_01.wsq" || 2
        "085_15_01.wsq" || 5
        "085_15_02.wsq" || 5
        "085_16_02.wsq" || 5
        "086_01_01.wsq" || 4
        "086_03_02.wsq" || 3
        "086_07_01.wsq" || 3
        "086_07_02.wsq" || 5
        "086_11_02.wsq" || 3
        "086_12_01.wsq" || 4
        "086_12_02.wsq" || 4
        "086_15_02.wsq" || 4
        "086_16_02.wsq" || 3
        "086_19_02.wsq" || 4
        "086_20_02.wsq" || 4
        "087_01_02.wsq" || 2
        "087_07_01.wsq" || 3
        "087_11_02.wsq" || 3
        "087_12_01.wsq" || 3
        "087_16_02.wsq" || 4
        "087_19_01.wsq" || 3
        "087_20_01.wsq" || 3
        "087_20_02.wsq" || 3
        "088_01_01.wsq" || 3
        "088_03_02.wsq" || 2
        "088_07_01.wsq" || 3
        "088_11_02.wsq" || 2
        "088_12_02.wsq" || 2
        "088_15_01.wsq" || 3
        "088_15_02.wsq" || 2
        "088_16_02.wsq" || 2
        "088_19_02.wsq" || 4
        "088_20_02.wsq" || 2
        "089_03_02.wsq" || 3
        "089_07_01.wsq" || 2
        "089_12_01.wsq" || 2
        "089_12_02.wsq" || 2
        "089_15_01.wsq" || 2
        "089_15_02.wsq" || 2
        "089_19_01.wsq" || 2
        "089_19_02.wsq" || 2
        "089_20_01.wsq" || 2
        "091_06_01.wsq" || 2
        "091_12_01.wsq" || 3
        "091_15_01.wsq" || 2
        "091_15_02.wsq" || 2
        "091_16_01.wsq" || 3
        "091_19_01.wsq" || 2
        "091_20_01.wsq" || 2
        "093_02_01.wsq" || 3
        "093_07_01.wsq" || 3
        "093_08_01.wsq" || 3
        "093_12_02.wsq" || 3
        "093_15_01.wsq" || 2
        "093_15_02.wsq" || 2
        "093_16_02.wsq" || 3
        "093_20_02.wsq" || 3
        "094_12_02.wsq" || 2
        "094_19_01.wsq" || 3
        "094_20_01.wsq" || 2
        "094_20_02.wsq" || 2
        "095_02_02.wsq" || 2
        "095_03_01.wsq" || 3
        "095_07_02.wsq" || 2
        "095_08_01.wsq" || 3
        "095_11_01.wsq" || 2
        "095_12_02.wsq" || 3
        "095_20_02.wsq" || 3
        "096_02_02.wsq" || 3
        "096_03_01.wsq" || 3
        "096_07_01.wsq" || 3
        "096_07_02.wsq" || 3
        "096_12_02.wsq" || 3
        "096_15_02.wsq" || 3
        "096_16_02.wsq" || 3
        "096_19_02.wsq" || 2
        "096_20_02.wsq" || 4
        "097_01_02.wsq" || 2
        "097_07_02.wsq" || 5
        "097_08_01.wsq" || 2
        "097_08_02.wsq" || 2
        "097_11_01.wsq" || 2
        "097_12_01.wsq" || 2
        "097_16_01.wsq" || 2
        "097_16_02.wsq" || 2
        "098_03_02.wsq" || 4
        "098_16_02.wsq" || 2
        "098_19_01.wsq" || 2
        "098_19_02.wsq" || 2
        "099_01_02.wsq" || 2
        "099_02_02.wsq" || 3
        "099_11_01.wsq" || 3
        "099_15_02.wsq" || 2
        "100_03_02.wsq" || 1
        "100_12_01.wsq" || 1
        "100_12_02.wsq" || 1
        "100_15_02.wsq" || 1
        "100_16_01.wsq" || 1
        "100_16_02.wsq" || 1
        "100_20_01.wsq" || 1
        "100_20_02.wsq" || 1
        "101_06_02.wsq" || 2
        "101_08_02.wsq" || 1
        "101_12_01.wsq" || 1
        "101_12_02.wsq" || 1
        "101_16_01.wsq" || 1
        "101_16_02.wsq" || 1
        "101_20_01.wsq" || 1
        "101_20_02.wsq" || 1
        "102_07_02.wsq" || 2
        "102_11_01.wsq" || 2
        "102_12_01.wsq" || 1
        "102_16_01.wsq" || 1
        "102_19_01.wsq" || 2
        "102_20_01.wsq" || 2
        "103_16_02.wsq" || 1
        "103_19_02.wsq" || 1
        "104_01_02.wsq" || 1
        "104_11_01.wsq" || 4
        "104_19_02.wsq" || 1
        "105_01_01.wsq" || 2
        "105_08_02.wsq" || 1
        "105_11_02.wsq" || 1
        "105_20_01.wsq" || 1
        "105_20_02.wsq" || 1
        "106_03_01.wsq" || 1
        "106_07_01.wsq" || 1
        "106_08_01.wsq" || 1
        "106_11_02.wsq" || 1
        "106_12_01.wsq" || 1
        "106_15_02.wsq" || 1
        "106_19_01.wsq" || 1
        "107_11_02.wsq" || 1
        "107_12_02.wsq" || 1
        "107_15_02.wsq" || 1
        "107_16_01.wsq" || 2
        "107_16_02.wsq" || 2
        "107_19_01.wsq" || 3
        "109_12_01.wsq" || 1
        "109_12_02.wsq" || 1
        "109_15_01.wsq" || 1
        "109_15_02.wsq" || 1
        "109_16_01.wsq" || 1
        "109_16_02.wsq" || 1
        "109_20_02.wsq" || 1
        "111_02_02.wsq" || 1
        "111_15_02.wsq" || 5
        "111_16_02.wsq" || 5
        "111_20_02.wsq" || 1
        "112_15_02.wsq" || 2
        "112_19_01.wsq" || 1
        "112_19_02.wsq" || 1
        "113_02_01.wsq" || 1
        "113_11_01.wsq" || 1
        "113_12_01.wsq" || 1
        "113_15_02.wsq" || 2
        "114_06_01.wsq" || 2
        "114_07_01.wsq" || 5
        "114_07_02.wsq" || 5
        "114_11_01.wsq" || 4
        "114_11_02.wsq" || 4
        "114_12_01.wsq" || 3
        "114_19_02.wsq" || 5
        "114_20_01.wsq" || 2
        "115_16_02.wsq" || 1
        "117_06_01.wsq" || 5
        "117_15_01.wsq" || 3
        "117_16_01.wsq" || 2
        "117_20_01.wsq" || 2
        "118_02_01.wsq" || 3
        "118_11_01.wsq" || 1
        "118_11_02.wsq" || 1
        "118_19_01.wsq" || 2
        "118_20_02.wsq" || 2
        "119_15_02.wsq" || 3
        "119_16_01.wsq" || 1
        "119_19_01.wsq" || 1
        "121_06_02.wsq" || 2
        "121_11_01.wsq" || 1
        "121_12_01.wsq" || 1
        "122_02_02.wsq" || 1
        "122_03_02.wsq" || 1
        "122_07_02.wsq" || 1
        "122_08_01.wsq" || 1
        "122_08_02.wsq" || 1
        "122_11_01.wsq" || 1
        "122_11_02.wsq" || 1
        "122_15_01.wsq" || 2
        "122_15_02.wsq" || 3
        "122_16_02.wsq" || 1
        "122_20_02.wsq" || 1
        "123_02_01.wsq" || 1
        "123_03_01.wsq" || 1
        "123_11_01.wsq" || 1
        "123_11_02.wsq" || 1
        "123_12_02.wsq" || 2
        "123_15_01.wsq" || 1
        "124_01_02.wsq" || 2
        "124_03_01.wsq" || 2
        "124_03_02.wsq" || 2
        "124_07_01.wsq" || 2
        "124_07_02.wsq" || 2
        "124_11_02.wsq" || 2
        "124_15_01.wsq" || 1
        "124_19_02.wsq" || 1
        "124_20_01.wsq" || 1
        "124_20_02.wsq" || 1
        "125_03_02.wsq" || 2
        "125_06_02.wsq" || 2
        "125_07_02.wsq" || 2
        "125_20_02.wsq" || 2
        "126_16_01.wsq" || 2
        "126_16_02.wsq" || 2
        "126_19_01.wsq" || 1
        "127_06_01.wsq" || 2
        "127_11_01.wsq" || 2
        "127_15_01.wsq" || 1
        "127_15_02.wsq" || 1
        "127_16_01.wsq" || 1
        "127_16_02.wsq" || 1
        "127_20_01.wsq" || 1
        "127_20_02.wsq" || 1
        "128_02_02.wsq" || 2
        "128_06_01.wsq" || 2
        "128_08_02.wsq" || 2
        "128_20_01.wsq" || 2
        "128_20_02.wsq" || 2
        "129_06_01.wsq" || 2
        "129_12_02.wsq" || 1
        "129_15_02.wsq" || 3
        "129_19_01.wsq" || 3
        "129_19_02.wsq" || 3
        "129_20_01.wsq" || 1
        "130_03_01.wsq" || 1
        "130_03_02.wsq" || 1
        "130_19_02.wsq" || 4
        "131_03_01.wsq" || 2
        "131_07_02.wsq" || 3
        "131_16_02.wsq" || 3
        "131_20_02.wsq" || 1
        "132_08_01.wsq" || 1
        "132_12_01.wsq" || 1
        "132_12_02.wsq" || 1
        "132_16_02.wsq" || 1
        "132_19_02.wsq" || 5
        "132_20_02.wsq" || 2
        "133_01_02.wsq" || 2
        "133_07_02.wsq" || 1
        "133_19_02.wsq" || 2
        "134_01_01.wsq" || 1
        "134_01_02.wsq" || 1
        "135_16_01.wsq" || 1
        "135_19_02.wsq" || 2
        "136_16_01.wsq" || 1
        "136_16_02.wsq" || 1
        "136_19_02.wsq" || 1
        "136_20_02.wsq" || 1
        "137_03_02.wsq" || 1
        "137_07_01.wsq" || 2
        "137_11_02.wsq" || 2
        "138_11_01.wsq" || 1
        "138_16_01.wsq" || 1
        "138_16_02.wsq" || 1
        "139_07_02.wsq" || 5
        "139_12_01.wsq" || 1
        "139_16_02.wsq" || 1
        "139_20_01.wsq" || 1
        "139_20_02.wsq" || 1
        "140_03_02.wsq" || 1
        "141_20_02.wsq" || 1
        "142_06_01.wsq" || 5
        "142_06_02.wsq" || 5
        "142_20_01.wsq" || 4
        "142_20_02.wsq" || 3
        "143_01_01.wsq" || 2
        "143_01_02.wsq" || 2
        "143_06_01.wsq" || 2
        "143_11_01.wsq" || 1
        "143_11_02.wsq" || 1
        "143_12_01.wsq" || 1
        "143_12_02.wsq" || 1
        "143_15_01.wsq" || 2
        "143_20_01.wsq" || 1
        "144_08_01.wsq" || 1
        "144_08_02.wsq" || 1
        "144_20_01.wsq" || 1
        "146_08_01.wsq" || 1
        "146_11_01.wsq" || 1
        "146_12_02.wsq" || 1
        "147_01_02.wsq" || 1
        "147_07_01.wsq" || 1
        "147_12_02.wsq" || 1
        "147_20_01.wsq" || 2
        "147_20_02.wsq" || 2
        "148_11_02.wsq" || 1
        "148_16_01.wsq" || 1
        "148_16_02.wsq" || 1
        "148_19_02.wsq" || 1
        "148_20_01.wsq" || 1
        "148_20_02.wsq" || 1
        "150_12_01.wsq" || 1
        "150_19_01.wsq" || 5
        "150_20_01.wsq" || 1
        "151_11_01.wsq" || 1
        "151_19_01.wsq" || 1
        "151_20_01.wsq" || 1
        "153_11_01.wsq" || 1
        "153_11_02.wsq" || 1
        "153_12_01.wsq" || 1
        "153_12_02.wsq" || 1
        "153_16_02.wsq" || 1
        "154_01_01.wsq" || 5
        "154_02_01.wsq" || 5
        "154_02_02.wsq" || 3
        "154_08_01.wsq" || 5
        "154_08_02.wsq" || 5
        "154_11_01.wsq" || 3
        "154_11_02.wsq" || 3
        "154_20_01.wsq" || 2
        "155_02_01.wsq" || 1
        "155_07_01.wsq" || 1
        "155_07_02.wsq" || 1
        "155_11_01.wsq" || 1
        "155_11_02.wsq" || 1
        "155_12_01.wsq" || 1
        "155_12_02.wsq" || 1
        "155_15_01.wsq" || 1
        "155_15_02.wsq" || 1
        "155_16_01.wsq" || 1
        "155_16_02.wsq" || 1
        "155_20_01.wsq" || 1
        "155_20_02.wsq" || 1
        "156_19_02.wsq" || 3
        "157_02_02.wsq" || 1
        "157_08_01.wsq" || 1
        "157_08_02.wsq" || 1
        "157_19_02.wsq" || 2
        "157_20_01.wsq" || 1
        "157_20_02.wsq" || 1
        "158_02_01.wsq" || 1
        "158_02_02.wsq" || 1
        "158_12_02.wsq" || 1
        "158_20_01.wsq" || 1
        "159_03_02.wsq" || 1
        "159_08_02.wsq" || 1
        "159_15_02.wsq" || 4
        "159_16_02.wsq" || 1
        "159_19_01.wsq" || 3
        "159_19_02.wsq" || 2
        "159_20_02.wsq" || 1
        "160_12_01.wsq" || 2
        "160_19_01.wsq" || 1
        "160_19_02.wsq" || 1
        "161_01_01.wsq" || 1
        "161_01_02.wsq" || 1
        "161_07_01.wsq" || 1
        "161_07_02.wsq" || 1
        "161_08_01.wsq" || 1
        "161_19_01.wsq" || 2
        "161_19_02.wsq" || 2
        "162_01_01.wsq" || 5
        "162_01_02.wsq" || 5
        "162_08_01.wsq" || 1
        "162_08_02.wsq" || 1
        "162_19_01.wsq" || 1
        "162_19_02.wsq" || 1
        "163_11_01.wsq" || 1
        "163_11_02.wsq" || 1
        "163_12_01.wsq" || 1
        "163_12_02.wsq" || 1
        "163_16_02.wsq" || 1
        "165_11_01.wsq" || 4
        "165_12_01.wsq" || 4
        "165_20_01.wsq" || 5
        "166_01_01.wsq" || 4
        "166_06_01.wsq" || 5
        "166_06_02.wsq" || 5
        "166_08_02.wsq" || 4
        "166_11_02.wsq" || 3
        "166_12_01.wsq" || 4
        "166_15_02.wsq" || 2
        "166_16_02.wsq" || 4
        "167_20_01.wsq" || 3
        "168_01_02.wsq" || 1
        "168_11_01.wsq" || 1
        "168_11_02.wsq" || 1
        "168_19_02.wsq" || 1
        "169_03_02.wsq" || 1
        "169_20_02.wsq" || 1
        "171_07_01.wsq" || 2
        "171_11_02.wsq" || 1
        "171_16_01.wsq" || 3
        "171_16_02.wsq" || 3
        "171_20_02.wsq" || 4
        "172_01_01.wsq" || 1
        "172_16_01.wsq" || 3
        "173_01_01.wsq" || 1
        "173_07_02.wsq" || 5
        "173_11_01.wsq" || 1
        "173_11_02.wsq" || 1
        "173_16_02.wsq" || 1
        "174_12_02.wsq" || 1
        "175_07_01.wsq" || 1
        "175_08_01.wsq" || 1
        "175_08_02.wsq" || 1
        "175_11_01.wsq" || 1
        "175_11_02.wsq" || 1
        "175_20_01.wsq" || 1
        "176_02_02.wsq" || 1
        "176_08_01.wsq" || 1
        "176_11_01.wsq" || 1
        "176_11_02.wsq" || 1
        "176_12_01.wsq" || 1
        "176_12_02.wsq" || 1
        "176_15_01.wsq" || 1
        "176_15_02.wsq" || 1
        "176_19_01.wsq" || 1
        "176_19_02.wsq" || 1
        "176_20_01.wsq" || 1
        "176_20_02.wsq" || 1
        "177_11_01.wsq" || 1
        "177_16_02.wsq" || 2
        "178_01_02.wsq" || 1
        "178_06_01.wsq" || 2
        "178_07_01.wsq" || 1
        "178_15_01.wsq" || 1
        "178_15_02.wsq" || 1
        "178_16_01.wsq" || 1
        "178_16_02.wsq" || 1
        "178_19_02.wsq" || 1
        "178_20_01.wsq" || 1
        "179_08_01.wsq" || 1
        "179_08_02.wsq" || 1
        "179_12_01.wsq" || 1
        "179_12_02.wsq" || 1
        "179_15_02.wsq" || 1
        "179_16_02.wsq" || 1
        "179_20_01.wsq" || 1
        "179_20_02.wsq" || 1
        "180_02_02.wsq" || 1
        "180_11_01.wsq" || 1
        "180_11_02.wsq" || 1
        "180_12_01.wsq" || 1
        "180_12_02.wsq" || 1
        "180_16_02.wsq" || 1
        "180_19_02.wsq" || 1
        "181_03_02.wsq" || 1
        "181_11_01.wsq" || 1
        "181_11_02.wsq" || 1
        "182_03_01.wsq" || 1
        "182_03_02.wsq" || 1
        "182_11_01.wsq" || 1
        "182_12_01.wsq" || 1
        "182_12_02.wsq" || 1
        "182_15_02.wsq" || 4
        "182_19_01.wsq" || 3
        "182_20_01.wsq" || 5
        "182_20_02.wsq" || 5
        "183_01_02.wsq" || 2
        "183_07_01.wsq" || 1
        "183_08_01.wsq" || 1
        "183_08_02.wsq" || 1
        "183_12_01.wsq" || 1
        "184_02_01.wsq" || 1
        "184_03_01.wsq" || 1
        "184_07_01.wsq" || 1
        "184_07_02.wsq" || 1
        "184_08_01.wsq" || 1
        "184_08_02.wsq" || 1
        "184_12_01.wsq" || 1
        "184_12_02.wsq" || 1
        "184_15_01.wsq" || 1
        "184_15_02.wsq" || 1
        "184_19_02.wsq" || 5
        "184_20_02.wsq" || 2
        "186_03_02.wsq" || 1
        "186_07_01.wsq" || 1
        "186_07_02.wsq" || 1
        "186_15_02.wsq" || 1
        "186_19_01.wsq" || 2
        "187_03_02.wsq" || 1
        "187_06_01.wsq" || 2
        "187_11_01.wsq" || 1
        "187_11_02.wsq" || 1
        "187_15_02.wsq" || 1
        "188_15_02.wsq" || 1
        "188_19_02.wsq" || 1
        "189_12_02.wsq" || 1
        "190_16_02.wsq" || 4
        "190_19_01.wsq" || 2
        "191_15_01.wsq" || 1
        "191_16_01.wsq" || 1
        "191_19_02.wsq" || 1
        "192_07_02.wsq" || 1
        "192_16_01.wsq" || 2
        "192_20_01.wsq" || 2
        "192_20_02.wsq" || 3
        "193_01_02.wsq" || 1
        "193_02_01.wsq" || 1
        "193_11_01.wsq" || 1
        "193_11_02.wsq" || 1
        "193_12_01.wsq" || 1
        "193_12_02.wsq" || 1
        "193_16_01.wsq" || 1
        "193_16_02.wsq" || 1
        "193_20_02.wsq" || 1
        "195_16_01.wsq" || 1
        "195_16_02.wsq" || 1
        "196_02_02.wsq" || 1
        "196_11_01.wsq" || 1
        "196_11_02.wsq" || 1
        "196_12_01.wsq" || 1
        "196_12_02.wsq" || 1
        "196_16_01.wsq" || 1
        "196_16_02.wsq" || 1
        "196_19_01.wsq" || 1
        "196_20_02.wsq" || 1
        "197_15_01.wsq" || 2
        "198_07_01.wsq" || 1
        "198_07_02.wsq" || 1
        "198_08_01.wsq" || 1
        "198_08_02.wsq" || 1
        "198_11_02.wsq" || 1
        "198_12_01.wsq" || 1
        "198_12_02.wsq" || 1
        "198_19_01.wsq" || 1
        "198_19_02.wsq" || 1
        "198_20_01.wsq" || 1
        "198_20_02.wsq" || 1
        "199_07_02.wsq" || 1
        "199_08_01.wsq" || 1
        "199_12_01.wsq" || 1
        "199_12_02.wsq" || 1
        "199_16_01.wsq" || 1
        "199_16_02.wsq" || 1
        "199_19_02.wsq" || 1
        "200_08_02.wsq" || 1
        "200_20_01.wsq" || 1
        "200_20_02.wsq" || 1
        "202_01_02.wsq" || 1
        "202_08_02.wsq" || 1
        "202_11_01.wsq" || 1
        "202_12_01.wsq" || 1
        "202_12_02.wsq" || 1
        "203_11_01.wsq" || 2
        "203_16_01.wsq" || 2
        "205_02_02.wsq" || 2
        "205_12_01.wsq" || 1
        "205_12_02.wsq" || 1
        "205_20_01.wsq" || 1
        "208_15_01.wsq" || 2
        "208_16_01.wsq" || 1
        "208_20_01.wsq" || 2
        "208_20_02.wsq" || 2
        "209_12_02.wsq" || 1
        "209_16_02.wsq" || 1
        "209_19_02.wsq" || 1
        "210_02_01.wsq" || 1
        "210_02_02.wsq" || 1
        "210_12_01.wsq" || 1
        "210_12_02.wsq" || 1
        "210_15_02.wsq" || 1
        "210_16_01.wsq" || 1
        "210_16_02.wsq" || 1
        "210_19_02.wsq" || 1
        "211_08_02.wsq" || 1
        "211_16_02.wsq" || 2
        "212_03_02.wsq" || 1
        "212_07_02.wsq" || 1
        "212_08_02.wsq" || 1
        "212_11_02.wsq" || 1
        "212_16_01.wsq" || 1
        "212_16_02.wsq" || 1
        "212_20_01.wsq" || 1
        "212_20_02.wsq" || 1
        "213_15_01.wsq" || 1
        "213_15_02.wsq" || 1
        "213_20_01.wsq" || 1
        "215_19_01.wsq" || 1
        "215_20_02.wsq" || 3
        "216_02_01.wsq" || 1
        "216_08_01.wsq" || 1
        "216_15_01.wsq" || 1
        "216_15_02.wsq" || 1
        "216_20_01.wsq" || 2
    }
}
