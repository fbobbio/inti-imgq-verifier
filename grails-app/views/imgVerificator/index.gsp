<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'imgVerificator.label', default: 'ImgVerificator')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-imgVerificator" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="verificator.new.label" /></g:link></li>
            </ul>
        </div>
        <div id="list-imgVerificator" class="content scaffold-list" role="main">
            <h1><g:message code="verificator.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${imgVerificatorList}" />

            <div class="pagination">
                <g:paginate total="${imgVerificatorCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
