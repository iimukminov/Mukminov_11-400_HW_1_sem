<#include "base.ftl">

<#macro title>Main page</#macro>

<#macro content>
    <a href="index.ftl">Главное меню</a>
    <br>
    <br>
    <h3>
        <img src="${src}" alt="">
        <br>
        Hello, ${sessionUser}! Login successful
        <br>
        Session ID = ${sessionId}
        <br>
        Cookie user = ${cookieUser}
    </h3>
</#macro>