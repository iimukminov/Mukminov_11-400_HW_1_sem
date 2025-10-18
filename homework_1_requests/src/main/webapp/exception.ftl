<#include "base.ftl">

<#macro title>Exception details</#macro>

<#macro content>
    <h1>Exception details:</h1>
    <br>
    <strong> Request uri: ${uri}</strong>
    <br>
    <strong> Status code: ${statusCode}</strong>
    <br>
    <#if message??><strong> ${message}</strong></#if>
</#macro>

</html>