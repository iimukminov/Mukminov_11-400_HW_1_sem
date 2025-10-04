<#include "base.ftl">

<#macro title>SignUp page</#macro>

<#macro content>
    <a href="index.ftl">Главное меню</a>
    <br>
    <form method="post" action="/signUp">
        Login:
        <input type="text" name="login" placeholder="LOGIN">
        Password:
        <input type="password" name="password" placeholder="PASSWORD">
        Name:
        <input type="text" name="name" placeholder="NAME">
        LastName:
        <input type="text" name="lastname" placeholder="LASTNAME">

        <input type="submit" value="SIGN UP">
    </form>
</#macro>