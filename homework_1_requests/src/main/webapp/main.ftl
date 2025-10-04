<#include "base.ftl">

<#macro title>Main page</#macro>

<#macro content>
    <a href="index.ftl">Главное меню</a>
    <br>
    <h3>
        Hello, ${sessionUser}! Login successful
        <br>
        Session ID = ${sessionId}
        <br>
        Cookie user = ${cookieUser}
    </h3>
</#macro>