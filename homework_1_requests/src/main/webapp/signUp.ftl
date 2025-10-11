<#include "base.ftl">

<#macro title>SignUp page</#macro>

<script>
    $('#signUp-login').on('input', function () {
        console.log("Checking");
        const login = $(this).val();

        $.get("/signUp/check", {login: login}, function (response) {
            if (response !== "") {
                $('input[type="submit"]').attr('disabled', true);
            } else {
                $('input[type="submit"]').attr('disabled', false);
            }
            $("#entering-response").text(response)
        })



    })
</script>


<#macro content>
    <a href="index.ftl">Главное меню</a>
    <br>
    <br>
    <form method="post" action="/signUp" style="display: flex;align-items: flex-start;gap: 10px;">
        Login:
        <div>
            <input type="text" id="signUp-login" name="login" placeholder="LOGIN">
            <p id="entering-response"></p>
        </div>
        Password:
        <input type="password" name="password" placeholder="PASSWORD">
        Name:
        <input type="text" name="name" placeholder="NAME">
        LastName:
        <input type="text" name="lastname" placeholder="LASTNAME">

        <input type="submit" id="button-submit" value="SIGN UP">
    </form>
    <br>
    <h4 style="margin-left: 10px;">
        ${signUpResult!}
    </h4>
</#macro>