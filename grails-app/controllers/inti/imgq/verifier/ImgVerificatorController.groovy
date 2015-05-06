package inti.imgq.verifier

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ImgVerificatorController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ImgVerificator.list(params), model:[imgVerificatorCount: ImgVerificator.count()]
    }

    def show(ImgVerificator imgVerificator) {
        respond imgVerificator
    }

    def imageQuality() {
      def verificator = new ImgVerificator(params)
      verificator.nfiq()
      render "El valor NFIQ de la imagen con ruta " + verificator.imgSrc + " es: " +  verificator.nfiqValue
    }

    def create() {
        respond new ImgVerificator(params)
    }

    @Transactional
    def save(ImgVerificator imgVerificator) {
        if (imgVerificator == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (imgVerificator.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond imgVerificator.errors, view:'create'
            return
        }

        imgVerificator.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'imgVerificator.label', default: 'ImgVerificator'), imgVerificator.id])
                redirect imgVerificator
            }
            '*' { respond imgVerificator, [status: CREATED] }
        }
    }

    def edit(ImgVerificator imgVerificator) {
        respond imgVerificator
    }

    @Transactional
    def update(ImgVerificator imgVerificator) {
        if (imgVerificator == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (imgVerificator.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond imgVerificator.errors, view:'edit'
            return
        }

        imgVerificator.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'imgVerificator.label', default: 'ImgVerificator'), imgVerificator.id])
                redirect imgVerificator
            }
            '*'{ respond imgVerificator, [status: OK] }
        }
    }

    @Transactional
    def delete(ImgVerificator imgVerificator) {

        if (imgVerificator == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        imgVerificator.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'imgVerificator.label', default: 'ImgVerificator'), imgVerificator.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'imgVerificator.label', default: 'ImgVerificator'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
