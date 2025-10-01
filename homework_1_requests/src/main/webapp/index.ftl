<html lang="en">
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
        <br>
        <form method="get" action="/signup">
            <input type="submit" value="SignUp"/>
        </form>
    </div>
</#macro>

</html>