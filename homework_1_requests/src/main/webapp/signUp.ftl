<html lang="en">
<#include "base.ftl">

<#macro title>SignUp page</#macro>

<#macro content>
    <form method="post" action="/signUp">
        Login:
        <input type="text" name="login" placeholder="LOGIN">
        Password:
        <input type="password" name="password" placeholder="PASSWORD">

        <input type="submit" value="SIGN UP">
    </form>
</#macro>

</html>