<html lang="en">
<#include "base.ftl">

<#macro title>Login page</#macro>

<#macro content>
    <form method="post" action="/login">
        Login:
        <input type="text" name="login" placeholder="type your login here">
        Password:
        <input type="password" name="password">
        <br>
        <input type="submit" value="login">
    </form>
</#macro>

</html>