<#include "base.ftl">

<#macro title>Index page</#macro>

<#macro content>
    <div id="my_body" class="block">
        <p>
            This is an example paragraph.
            Anything in the <strong>body</strong> tag will appear on the page.
        </p>
        <form method="get" action="/login">
            <input type="submit" value="Login"/>
        </form>

        <form method="get" action="/signUp">
            <input type="submit" value="SignUp"/>
        </form>

        <form method="get" action="/user">
            <input type="submit" value="Users"/>
        </form>

        <form method="get" action="/hello">
            <input type="submit" value="Hello"/>
        </form>

        <form method="get" action="/main">
            <input type="submit" value="Main"/>
        </form>

        <form method="get" action="/logout">
            <input type="submit" value="LogOut"/>
        </form>
    </div>
</#macro>