package inti.imgq.verifier

/**
 * Clase que representa una imagen particular en formato ANSI\/NIST de fingerprint
 *  y otorga capacidades de evaluación de calidad de imagen en estándares del NIST
*/
class ImgVerificator {

    byte[] img
    String imgType
    String imgSrc
    int nfiqValue
    String params = ""

    static constraints = {
      img nullable:false, maxSize: 1048576 /* 1MB */
      imgSrc nullable: false
      nfiqValue nullable: true
      params nullable: true
    }

    /**
     * Método que procesa el ingreso de una imagen a ser verificada.
     * Guarda la imagen a disco y asocia su ruta al objeto, luego calcula su valor de NFIQ y lo almacena.
    */
    //void process() {
    //}

    /**
     * Método que determina la calidad de imagen a partir del algoritmo NFIQ, almacena y devuelve su valor
     *
     * @return el valor NFIQ asociado a la imagen
    */
    void nfiq() {
      nfiqValue = ("nfiq -d " + params + imgSrc).execute().text.trim()[-1].toInteger()
    }
}
