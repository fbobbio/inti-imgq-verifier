<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'imgVerificator.label', default: 'ImgVerificator')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-imgVerificator" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="verificator.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="verificator.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-imgVerificator" class="content scaffold-show" role="main">
            <h1><g:message code="verificator.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:if test="${flash.warning}">
            <div class="errors" role="status"><li>${flash.warning}</li></div>
            </g:if>
            <f:display bean="imgVerificator" />
            </ol>
        </div>
    </body>
</html>
