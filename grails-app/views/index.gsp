<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>INTI Verificador de Calidad de Imagen de Huellas Digitales</title>
        <style type="text/css" media="screen">
            #status {
                background-color: #eee;
                border: .2em solid #fff;
                margin: 2em 2em 1em;
                padding: 1em;
                width: 12em;
                float: left;
                -moz-box-shadow: 0px 0px 1.25em #ccc;
                -webkit-box-shadow: 0px 0px 1.25em #ccc;
                box-shadow: 0px 0px 1.25em #ccc;
                -moz-border-radius: 0.6em;
                -webkit-border-radius: 0.6em;
                border-radius: 0.6em;
            }

            #status ul {
                font-size: 0.9em;
                list-style-type: none;
                margin-bottom: 0.6em;
                padding: 0;
            }

            #status li {
                line-height: 1.3;
            }

            #status h1 {
                text-transform: uppercase;
                font-size: 1.1em;
                margin: 0 0 0.3em;
            }

            #page-body {
                margin: 2em 1em 1.25em 18em;
            }

            h2 {
                margin-top: 1em;
                margin-bottom: 0.3em;
                font-size: 1em;
            }

            p {
                line-height: 1.5;
                margin: 0.25em 0;
            }

            #controller-list ul {
                list-style-position: inside;
            }

            #controller-list li {
                line-height: 1.3;
                list-style-position: inside;
                margin: 0.25em 0;
            }

            @media screen and (max-width: 480px) {
                #status {
                    display: none;
                }

                #page-body {
                    margin: 0 1em 1em;
                }

                #page-body h1 {
                    margin-top: 0;
                }
            }
        </style>
    </head>
    <body>
        <a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div id="status" role="complementary">
            <h1>Application Status</h1>
            <ul>
                <li>Environment: ${grails.util.Environment.current.name}</li>
                <li>App profile: ${grailsApplication.config.grails?.profile}</li>
                <li>App version: <g:meta name="info.app.version"/></li>
                <li>Grails version: <g:meta name="info.app.grailsVersion"/></li>
                <li>Groovy version: ${GroovySystem.getVersion()}</li>
                <li>JVM version: ${System.getProperty('java.version')}</li>
                <li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
            </ul>
            <h1>Artefacts</h1>
            <ul>
                <li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
                <li>Domains: ${grailsApplication.domainClasses.size()}</li>
                <li>Services: ${grailsApplication.serviceClasses.size()}</li>
                <li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>                    
            </ul>
            <h1>Installed Plugins</h1>
            <ul>
                <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                    <li>${plugin.name} - ${plugin.version}</li>
                </g:each>
            </ul>
        </div>
        <div id="page-body" role="main">
            <h1>Bienvenidos al servicio de Verificación de Calidad de Imagen de INTI</h1>
            <br>
            <p>El presente aplicativo sirve a la necesidad de verificar la calidad de imágenes en formato ANSI/NIST comprimidas con el algoritmo <g:link id="wsqLink" url="http://en.wikipedia.org/wiki/Wavelet_scalar_quantization" target="_blank">WSQ</g:link></p>
            <p>Se recepta una ruta absoluta de imagen WSQ, la cual se procesa con la implementación del algoritmo <g:link target="_blank" url="http://www.nist.gov/customcf/get_pdf.cfm?pub_id=905710">NFIQ</g:link> del aplicativo <g:link target="_blank" url="http://www.nist.gov/itl/iad/ig/nbis.cfm">NBIS</g:link> provisto por el <g:link target="_blank" url="http://www.nist.gov/">National Institute of Standards and Technology (NIST)</g:link> de los Estados Unidos, distribuído sin requerimientos de licencia.</p>
            <br>
            <p><ul>
              <li class="controller">Los 5 niveles de calidad de NFIQ’s están destinados a ser predictivos de la performance de un sistema de búsqueda a través de minucias de la huella dactilar.</li>
              <li class="controller">NFIQ = 1 indica una buena calidad de muestra, se espera un bajo FMR y/o FNMR.</li>
              <li class="controller">NFIQ = 5 indica una mala calidad de muestra, se espera un alto FMR y/o FNMR.</li>
            </ul></p>
            <br>

            <div id="controller-list" role="navigation">
                <h2>Funcionalidad disponible</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller"><g:link controller="${c.logicalPropertyName}">Validar Calidad de Imagen</g:link></li>
                    </g:each>
                </ul>
            </div>
        </div>
    </body>
</html>
