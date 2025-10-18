<#include "base.ftl">

<#macro title>SignUp page</#macro>

<script>
    $('#signUp-login').on('input', function () {
        console.log("Checking");
        const login = $(this).val();

        $.get("/signUp/check", {login: login}, function (response) {
            console.log(response)
            if (response !== "") {
                $('#button-submit').attr('disabled', true);
            } else {
                $('#button-submit').attr('disabled', false);
            }
            $("#entering-response").text(response)
        })
    })
</script>


<#macro content>
    <a href="index.ftl">Главное меню</a>
    <br>
    <br>
    <form method="post" action="/signUp" enctype="multipart/form-data">
        Choose your photo:<br>
        <input type="file" name="file">
        <br>
        Login:<br>
        <input type="text" id="signUp-login" name="login" placeholder="LOGIN">
        <p id="entering-response"></p>
        <br>
        Password:<br>
        <input type="password" name="password" placeholder="PASSWORD">
        <br>
        Name:<br>
        <input type="text" name="name" placeholder="NAME">
        <br>
        LastName:<br>
        <input type="text" name="lastname" placeholder="LASTNAME">
        <br>

        <input type="submit" id="button-submit" value="SIGN UP">
    </form>
    <br>
    <h4 style="margin-left: 10px;">
        ${signUpResult!}
    </h4>
</#macro>